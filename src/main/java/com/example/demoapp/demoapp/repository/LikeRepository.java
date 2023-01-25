package com.example.demoapp.demoapp.repository;

import com.example.demoapp.demoapp.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, String> {
}
