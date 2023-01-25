package com.example.demoapp.demoapp.dto.request;

public class UpdateUserRequest {

    private String firstName;
    private String lastName;
    private String password;

    public UpdateUserRequest() {}

    public UpdateUserRequest(String firstName, String lastName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }
}
