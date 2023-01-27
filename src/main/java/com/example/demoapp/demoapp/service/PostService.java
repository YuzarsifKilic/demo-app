package com.example.demoapp.demoapp.service;

import com.example.demoapp.demoapp.dto.convert.PostDtoConvert;
import com.example.demoapp.demoapp.dto.model.PostDto;
import com.example.demoapp.demoapp.dto.request.CreatePostRequest;
import com.example.demoapp.demoapp.dto.request.UpdatePostRequest;
import com.example.demoapp.demoapp.exception.PostNotfoundException;
import com.example.demoapp.demoapp.model.Post;
import com.example.demoapp.demoapp.model.User;
import com.example.demoapp.demoapp.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserService userService;
    private final PostDtoConvert postDtoConvert;

    public PostService(PostRepository postRepository, UserService userService, PostDtoConvert postDtoConvert) {
        this.postRepository = postRepository;
        this.userService = userService;
        this.postDtoConvert = postDtoConvert;
    }

    public List<PostDto> getAll() {

        return postRepository
                .findAll()
                .stream()
                .map(p -> postDtoConvert.convert(p))
                .collect(Collectors.toList());
    }

    public PostDto save(CreatePostRequest request) {
        User user = userService.findById(request.getId());
        Post post = new Post(
                user,
                request.getTitle(),
                request.getText());

        return postDtoConvert.convert(postRepository.save(post));
    }

    protected Post getById(String id) {
        return postRepository
                .findById(id)
                .orElseThrow(
                        () -> new PostNotfoundException(id + " ye sahip bir post buluınamadı"));
    }

    public PostDto getPost(String id) {
        Post post = postRepository
                .findById(id)
                .orElseThrow(
                        () -> new PostNotfoundException(id + " ye sahip bir post buluınamadı"));

        return postDtoConvert.convert(post);
    }

    public PostDto update(String postId, UpdatePostRequest request) {
        Post post = getById(postId);
        Post updatedPost = new Post(
                post.getId(),
                post.getUser(),
                request.getTitle(),
                request.getText());

        return postDtoConvert.convert(postRepository.save(updatedPost));
    }

    public List<PostDto> getByUserId(String userId) {
        return getAll()
                .stream()
                .filter(p -> Objects.equals(p.getUserDto().getId(), userId))
                .collect(Collectors.toList());
    }
}
