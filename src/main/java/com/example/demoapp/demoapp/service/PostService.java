package com.example.demoapp.demoapp.service;

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

    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public List<Post> getAll() {
        return postRepository.findAll();
    }

    public Post save(CreatePostRequest request) {
        User user = userService.findById(request.getId());
        Post post = new Post(
                user,
                request.getTitle(),
                request.getText());

        return postRepository.save(post);
    }

    public Post getById(String id) {
        return postRepository
                .findById(id)
                .orElseThrow(
                        () -> new PostNotfoundException(id + " ye sahip bir post buluınamadı"));
    }

    public Post update(String postId, UpdatePostRequest request) {
        Post post = getById(postId);
        Post updatedPost = new Post(
                post.getId(),
                post.getUser(),
                request.getTitle(),
                request.getText());

        return postRepository.save(updatedPost);
    }

    public List<Post> getByUserId(String userId) {
        return getAll()
                .stream()
                .filter(p -> Objects.equals(p.getUser().getId(), userId))
                .collect(Collectors.toList());
    }
}
