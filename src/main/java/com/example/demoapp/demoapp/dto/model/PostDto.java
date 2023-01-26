package com.example.demoapp.demoapp.dto.model;

public class PostDto {

    private String id;
    private UserDto userDto;
    private String title;
    private String text;

    public PostDto() {}

    public PostDto(String id, UserDto userDto, String title, String text) {
        this.id = id;
        this.userDto = userDto;
        this.title = title;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
