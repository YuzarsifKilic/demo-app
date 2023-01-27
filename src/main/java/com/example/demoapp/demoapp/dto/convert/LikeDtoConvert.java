package com.example.demoapp.demoapp.dto.convert;

import com.example.demoapp.demoapp.dto.model.LikeDto;
import com.example.demoapp.demoapp.model.Like;
import org.springframework.stereotype.Component;

@Component
public class LikeDtoConvert {

    private final UserDtoConvert userDtoConvert;
    private final PostDtoConvert postDtoConvert;

    public LikeDtoConvert(UserDtoConvert userDtoConvert, PostDtoConvert postDtoConvert) {
        this.userDtoConvert = userDtoConvert;
        this.postDtoConvert = postDtoConvert;
    }

    public LikeDto convert(Like from) {
        return new LikeDto(
                from.getId(),
                userDtoConvert.convert(from.getUser()),
                postDtoConvert.convert(from.getPost()));
    }
}
