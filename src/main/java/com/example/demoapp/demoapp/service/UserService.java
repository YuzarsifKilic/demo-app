package com.example.demoapp.demoapp.service;

import com.example.demoapp.demoapp.dto.convert.UserDtoConvert;
import com.example.demoapp.demoapp.dto.model.UserDto;
import com.example.demoapp.demoapp.dto.request.CreateUserRequest;
import com.example.demoapp.demoapp.dto.request.UpdateUserRequest;
import com.example.demoapp.demoapp.exception.UserNotFoundException;
import com.example.demoapp.demoapp.model.User;
import com.example.demoapp.demoapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserDtoConvert userDtoConvert;

    public UserService(UserRepository userRepository, UserDtoConvert userDtoConvert) {
        this.userRepository = userRepository;
        this.userDtoConvert = userDtoConvert;
    }

    public List<UserDto> getAll() {
        return userRepository
                .findAll()
                .stream()
                .map(u -> userDtoConvert.convert(u))
                .collect(Collectors.toList());
    }

    public UserDto save(CreateUserRequest request) {
        User user = new User(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPassword());
        return userDtoConvert.convert(userRepository.save(user));
    }

    public User findByEmail(String email) {
        return userRepository
                .findByEmail(email)
                .orElseThrow(
                        () -> new UserNotFoundException(email + " e sahip bir user bulunamadı"));
    }

    protected User findById(String id) {
        return userRepository
                .findById(id)
                .orElseThrow(
                        () -> new UserNotFoundException(id + " ye sahip bir user bulunamadı"));
    }

    public UserDto getUser(String id) {
        User user = userRepository
                .findById(id)
                .orElseThrow(
                        () -> new UserNotFoundException(id + " ye sahip bir user bulunamadı"));

        return userDtoConvert.convert(user);
    }

    public UserDto updateUser(String id, UpdateUserRequest request) {
        User user = findById(id);
        User updatedUser = new User(
                user.getId(),
                request.getFirstName(),
                request.getLastName(),
                user.getEmail(),
                request.getPassword());
        return userDtoConvert.convert(userRepository.save(updatedUser));
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
