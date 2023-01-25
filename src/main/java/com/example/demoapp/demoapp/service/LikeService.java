package com.example.demoapp.demoapp.service;

import com.example.demoapp.demoapp.dto.request.CreateLikeRequest;
import com.example.demoapp.demoapp.model.Like;
import com.example.demoapp.demoapp.model.Post;
import com.example.demoapp.demoapp.model.User;
import com.example.demoapp.demoapp.repository.LikeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {

    private final LikeRepository likeRepository;
    private final UserService userService;
    private final PostService postService;

    public LikeService(LikeRepository likeRepository, UserService userService, PostService postService) {
        this.likeRepository = likeRepository;
        this.userService = userService;
        this.postService = postService;
    }

    public List<Like> getAll() {
        return likeRepository.findAll();
    }

    public Like saveLike(CreateLikeRequest request) {
        User user = userService.findById(request.getUserId());
        Post post = postService.getById(request.getPostId());

        Like like = new Like(user, post);
        return likeRepository.save(like);
    }

    public void deleteLike(String userId, String postId) {
        User user = userService.findById(userId);
        Post post = postService.getById(postId);

        Like like = new Like(user, post);
        likeRepository.delete(like);
    }
}
