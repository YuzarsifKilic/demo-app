package com.example.demoapp.demoapp.repository;

import com.example.demoapp.demoapp.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, String> {
}
