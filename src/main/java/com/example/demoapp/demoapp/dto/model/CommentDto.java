package com.example.demoapp.demoapp.dto.model;

public class CommentDto {

    private String id;
    private UserDto userDto;
    private PostDto postDto;
    private String text;

    public CommentDto() {}

    public CommentDto(String id, UserDto userDto, PostDto postDto, String text) {
        this.id = id;
        this.userDto = userDto;
        this.postDto = postDto;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public PostDto getPostDto() {
        return postDto;
    }

    public String getText() {
        return text;
    }
}
