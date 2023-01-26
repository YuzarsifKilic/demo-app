package com.example.demoapp.demoapp.dto.convert;

import com.example.demoapp.demoapp.dto.model.CommentDto;
import com.example.demoapp.demoapp.model.Comment;

public class CommentDtoConvert {

    private final UserDtoConvert userDtoConvert;
    private final PostDtoConvert postDtoConvert;

    public CommentDtoConvert(UserDtoConvert userDtoConvert, PostDtoConvert postDtoConvert) {
        this.userDtoConvert = userDtoConvert;
        this.postDtoConvert = postDtoConvert;
    }

    public CommentDto convert(Comment from) {
        return new CommentDto(
                from.getId(),
                userDtoConvert.convert(from.getUser()),
                postDtoConvert.convert(from.getPost()),
                from.getText());
    }
}
