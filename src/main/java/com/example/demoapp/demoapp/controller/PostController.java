package com.example.demoapp.demoapp.controller;

import com.example.demoapp.demoapp.dto.request.CreatePostRequest;
import com.example.demoapp.demoapp.dto.request.UpdatePostRequest;
import com.example.demoapp.demoapp.model.Post;
import com.example.demoapp.demoapp.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/getall")
    public List<Post> getAll() {
        return postService.getAll();
    }

    @GetMapping("/byuser/{userId}")
    public List<Post> getPostsByUserId(@PathVariable String userId) {
        return postService.getByUserId(userId);
    }

    @PostMapping("/save")
    public Post savePost(@RequestBody CreatePostRequest request) {
        return postService.save(request);
    }

    @GetMapping("/{postId}")
    public Post getById(@PathVariable String postId) {
        return postService.getById(postId);
    }

    @PutMapping("/{postId}")
    public Post updatePost(@PathVariable String id, UpdatePostRequest request) {
        return postService.update(id, request);
    }
}
