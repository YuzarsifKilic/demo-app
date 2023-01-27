package com.example.demoapp.demoapp.service;

import com.example.demoapp.demoapp.dto.convert.LikeDtoConvert;
import com.example.demoapp.demoapp.dto.model.LikeDto;
import com.example.demoapp.demoapp.dto.request.CreateLikeRequest;
import com.example.demoapp.demoapp.model.Like;
import com.example.demoapp.demoapp.model.Post;
import com.example.demoapp.demoapp.model.User;
import com.example.demoapp.demoapp.repository.LikeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LikeService {

    private final LikeRepository likeRepository;
    private final UserService userService;
    private final PostService postService;
    private final LikeDtoConvert likeDtoConvert;

    public LikeService(
            LikeRepository likeRepository,
            UserService userService,
            PostService postService,
            LikeDtoConvert likeDtoConvert) {
        this.likeRepository = likeRepository;
        this.userService = userService;
        this.postService = postService;
        this.likeDtoConvert = likeDtoConvert;
    }

    public List<LikeDto> getAll() {
        return likeRepository
                .findAll()
                .stream()
                .map(l -> likeDtoConvert.convert(l))
                .collect(Collectors.toList());
    }

    public LikeDto saveLike(CreateLikeRequest request) {
        User user = userService.findById(request.getUserId());
        Post post = postService.getById(request.getPostId());

        Like like = new Like(user, post);
        return likeDtoConvert.convert(likeRepository.save(like));
    }

    public void deleteLike(String userId, String postId) {
        User user = userService.findById(userId);
        Post post = postService.getById(postId);

        Like like = new Like(user, post);
        likeRepository.delete(like);
    }
}
