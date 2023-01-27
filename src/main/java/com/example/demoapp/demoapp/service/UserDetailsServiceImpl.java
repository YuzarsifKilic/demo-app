package com.example.demoapp.demoapp.service;

import com.example.demoapp.demoapp.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.example.demoapp.demoapp.security.JwtUserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByEmail(username);
        return JwtUserDetails.create(user);
    }

    public UserDetails loadByUserId(String id) {
        User user = userService.findById(id);
        return JwtUserDetails.create(user);
    }
}
