package com.example.demoapp.demoapp.dto.request;

public class CreateCommentRequest {

    private String userId;
    private String postId;
    private String text;

    public CreateCommentRequest() {}

    public CreateCommentRequest(String userId, String postId, String text) {
        this.userId = userId;
        this.postId = postId;
        this.text = text;
    }

    public String getUserId() {
        return userId;
    }

    public String getPostId() {
        return postId;
    }

    public String getText() {
        return text;
    }
}
