package com.example.demoapp.demoapp.repository;

import com.example.demoapp.demoapp.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, String> {
}
