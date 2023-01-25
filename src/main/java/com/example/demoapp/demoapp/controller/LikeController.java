package com.example.demoapp.demoapp.controller;

import com.example.demoapp.demoapp.dto.request.CreateLikeRequest;
import com.example.demoapp.demoapp.model.Like;
import com.example.demoapp.demoapp.service.LikeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/like")
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping("/getall")
    public List<Like> getAll() {
        return likeService.getAll();
    }

    @PostMapping("/save")
    public Like save(@RequestBody CreateLikeRequest request) {
        return likeService.saveLike(request);
    }

    @DeleteMapping("/{userId}/{postId}")
    public void delete(@PathVariable String userId, @PathVariable String postId) {
        likeService.deleteLike(userId, postId);
    }
}
