package com.example.demoapp.demoapp.dto.convert;

import com.example.demoapp.demoapp.dto.model.UserDto;
import com.example.demoapp.demoapp.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConvert {

    public UserDto convert(User from) {
        return new UserDto(
                from.getId(),
                from.getFirstName(),
                from.getLastName(),
                from.getEmail());
    }
}
