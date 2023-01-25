package com.example.demoapp.demoapp.dto.request;

public class UpdatePostRequest {

    private String title;
    private String text;

    public UpdatePostRequest() {}

    public UpdatePostRequest(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
