package com.example.demoapp.demoapp.dto.request;

public class CreatePostRequest {

    private String id;
    private String title;
    private String text;

    public CreatePostRequest() {}

    public CreatePostRequest(String id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
