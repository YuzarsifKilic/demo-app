package com.example.demoapp.demoapp.controller;

import com.example.demoapp.demoapp.dto.model.UserDto;
import com.example.demoapp.demoapp.dto.request.CreateUserRequest;
import com.example.demoapp.demoapp.dto.request.UpdateUserRequest;
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
    public List<UserDto> getAll() {
        return userService.getAll();
    }

    @PostMapping("/save")
    public UserDto saveUser(@RequestBody CreateUserRequest request) {
        return userService.save(request);
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable String id) {
        return userService.getUser(id);
    }

    @PutMapping("/{userId}")
    public UserDto updateUser(@PathVariable String userId, UpdateUserRequest request) {
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable String id) {
       userService.deleteUser(id);
    }
}
