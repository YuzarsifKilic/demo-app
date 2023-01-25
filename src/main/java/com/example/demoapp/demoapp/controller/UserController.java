package com.example.demoapp.demoapp.controller;

import com.example.demoapp.demoapp.dto.request.CreateUserRequest;
import com.example.demoapp.demoapp.dto.request.UpdateUserRequest;
import com.example.demoapp.demoapp.model.User;
import com.example.demoapp.demoapp.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getall")
    public List<User> getAll() {
        return userService.getAll();
    }

    @PostMapping("/save")
    public User saveUser(@RequestBody CreateUserRequest request) {
        return userService.save(request);
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable String id) {
        return userService.findById(id);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable String userId, UpdateUserRequest request) {
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable String id) {
       userService.deleteUser(id);
    }
}
