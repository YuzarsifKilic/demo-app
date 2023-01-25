package com.example.demoapp.demoapp.service;

import com.example.demoapp.demoapp.dto.request.CreateUserRequest;
import com.example.demoapp.demoapp.dto.request.UpdateUserRequest;
import com.example.demoapp.demoapp.exception.UserNotFoundException;
import com.example.demoapp.demoapp.model.User;
import com.example.demoapp.demoapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User save(CreateUserRequest request) {
        User user = new User(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPassword());
        return userRepository.save(user);
    }

    public User findById(String id) {
        return userRepository
                .findById(id)
                .orElseThrow(
                        () -> new UserNotFoundException(id + " ye sahipr bir user bulunamadı"));
    }

    public User updateUser(String id, UpdateUserRequest request) {
        User user = findById(id);
        User updatedUser = new User(
                user.getId(),
                request.getFirstName(),
                request.getLastName(),
                user.getEmail(),
                request.getPassword());
        return userRepository.save(updatedUser);
    }

    public void deleteUser(String id) {
        User user = findById(id);
        userRepository.delete(user);
    }
}
