package com.example.demoapp.demoapp.controller;

import com.example.demoapp.demoapp.dto.request.CreateCommentRequest;
import com.example.demoapp.demoapp.dto.request.UpdateCommentRequest;
import com.example.demoapp.demoapp.model.Comment;
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
    public List<Comment> getAll() {
        return commentService.getAll();
    }

    @GetMapping("/save")
    public Comment save(@RequestBody CreateCommentRequest request) {
        return commentService.saveComment(request);
    }

    @GetMapping("/{commentId}")
    public Comment getById(@PathVariable String commentId) {
        return commentService.findById(commentId);
    }

    @PutMapping("/get/{userId}/{postId}")
    public Comment update(
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
