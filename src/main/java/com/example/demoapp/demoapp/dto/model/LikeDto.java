package com.example.demoapp.demoapp.dto.model;

public class LikeDto {

    private String id;
    private UserDto userDto;
    private PostDto postDto;

    public LikeDto() {}

    public LikeDto(String id, UserDto userDto, PostDto postDto) {
        this.id = id;
        this.userDto = userDto;
        this.postDto = postDto;
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
}
