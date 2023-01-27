package com.example.demoapp.demoapp.service;

import com.example.demoapp.demoapp.dto.convert.CommentDtoConvert;
import com.example.demoapp.demoapp.dto.model.CommentDto;
import com.example.demoapp.demoapp.dto.request.CreateCommentRequest;
import com.example.demoapp.demoapp.dto.request.UpdateCommentRequest;
import com.example.demoapp.demoapp.exception.CommentNotFoundException;
import com.example.demoapp.demoapp.model.Comment;
import com.example.demoapp.demoapp.model.Post;
import com.example.demoapp.demoapp.model.User;
import com.example.demoapp.demoapp.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserService userService;
    private final PostService postService;
    private final CommentDtoConvert commentDtoConvert;

    public CommentService(
            CommentRepository commentRepository,
            UserService userService,
            PostService postService,
            CommentDtoConvert commentDtoConvert) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.postService = postService;
        this.commentDtoConvert = commentDtoConvert;
    }

    public List<CommentDto> getAll() {

        return commentRepository
                .findAll()
                .stream()
                .map(c -> commentDtoConvert.convert(c))
                .collect(Collectors.toList());
    }

    public CommentDto saveComment(CreateCommentRequest request) {
        User user = userService.findById(request.getUserId());
        Post post = postService.getById(request.getPostId());
        Comment comment = new Comment(
                user,
                post,
                request.getText());

        return commentDtoConvert.convert(commentRepository.save(comment));
    }

    public CommentDto updateComment(String userId, String postId, UpdateCommentRequest request) {
        User user = userService.findById(userId);
        Post post = postService.getById(postId);

        Comment comment = new Comment(
                user,
                post,
                request.getText());

        return commentDtoConvert.convert(commentRepository.save(comment));
    }

    public void deleteComment(String commentId) {
        commentRepository.deleteById(commentId);
    }

    public CommentDto findById(String commentId) {
        Comment comment = commentRepository
                .findById(commentId)
                .orElseThrow(
                        () -> new CommentNotFoundException(commentId + " ye sahip bir comment bulunamadı"));

        return commentDtoConvert.convert(comment);
    }
}
