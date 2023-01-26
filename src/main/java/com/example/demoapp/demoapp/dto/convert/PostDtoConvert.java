package com.example.demoapp.demoapp.dto.convert;

import com.example.demoapp.demoapp.dto.model.PostDto;
import com.example.demoapp.demoapp.model.Post;
import org.springframework.stereotype.Component;

@Component
public class PostDtoConvert {

    private final UserDtoConvert convert;

    public PostDtoConvert(UserDtoConvert convert) {
        this.convert = convert;
    }

    public PostDto convert(Post from) {
        return new PostDto(
                from.getId(),
                convert.convert(from.getUser()),
                from.getTitle(),
                from.getText());
    }
}
