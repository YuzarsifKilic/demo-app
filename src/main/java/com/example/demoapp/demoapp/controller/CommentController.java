package com.example.demoapp.demoapp.controller;

import com.example.demoapp.demoapp.dto.model.CommentDto;
import com.example.demoapp.demoapp.dto.request.CreateCommentRequest;
import com.example.demoapp.demoapp.dto.request.UpdateCommentRequest;
import com.example.demoapp.demoapp.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/getall")
    public List<CommentDto> getAll() {
        return commentService.getAll();
    }

    @PostMapping("/save")
    public CommentDto save(@RequestBody CreateCommentRequest request) {
        return commentService.saveComment(request);
    }

    @GetMapping("/{commentId}")
    public CommentDto getById(@PathVariable String commentId) {
        return commentService.findById(commentId);
    }

    @PutMapping("/get/{userId}/{postId}")
    public CommentDto update(
            @PathVariable String userId,
            @PathVariable String postId,
            @RequestBody UpdateCommentRequest request) {
        return commentService.updateComment(userId, postId, request);
    }

    @DeleteMapping("/{commentId}")
    public void delete(@PathVariable String commentId) {
        commentService.deleteComment(commentId);
    }
}
