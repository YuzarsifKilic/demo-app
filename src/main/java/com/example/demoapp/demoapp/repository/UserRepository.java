package com.example.demoapp.demoapp.repository;

import com.example.demoapp.demoapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
