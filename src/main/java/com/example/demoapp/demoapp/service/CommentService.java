package com.example.demoapp.demoapp.service;

import com.example.demoapp.demoapp.dto.request.CreateCommentRequest;
import com.example.demoapp.demoapp.dto.request.UpdateCommentRequest;
import com.example.demoapp.demoapp.exception.CommentNotFoundException;
import com.example.demoapp.demoapp.model.Comment;
import com.example.demoapp.demoapp.model.Post;
import com.example.demoapp.demoapp.model.User;
import com.example.demoapp.demoapp.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserService userService;
    private final PostService postService;

    public CommentService(CommentRepository commentRepository, UserService userService, PostService postService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.postService = postService;
    }

    public List<Comment> getAll() {
        return commentRepository.findAll();
    }

    public Comment saveComment(CreateCommentRequest request) {
        User user = userService.findById(request.getUserId());
        Post post = postService.getById(request.getPostId());
        Comment comment = new Comment(
                user,
                post,
                request.getText());

        return commentRepository.save(comment);
    }

    public Comment updateComment(String userId, String postId, UpdateCommentRequest request) {
        User user = userService.findById(userId);
        Post post = postService.getById(postId);

        Comment comment = new Comment(
                user,
                post,
                request.getText());

        return commentRepository.save(comment);
    }

    public void deleteComment(String commentId) {
        Comment comment = findById(commentId);
        commentRepository.delete(comment);
    }

    public Comment findById(String commentId) {
        return commentRepository
                .findById(commentId)
                .orElseThrow(
                        () -> new CommentNotFoundException(commentId + " ye sahip bir comment bulunamadı"));
    }
}
