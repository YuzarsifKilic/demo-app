package com.example.demoapp.demoapp.dto.request;

public class CreateLikeRequest {

    private String userId;
    private String postId;

    public CreateLikeRequest() {}

    public CreateLikeRequest(String userId, String postId) {
        this.userId = userId;
        this.postId = postId;
    }

    public String getUserId() {
        return userId;
    }

    public String getPostId() {
        return postId;
    }
}
