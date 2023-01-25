package com.example.demoapp.demoapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PostNotfoundException extends RuntimeException {

    public PostNotfoundException(String message) {
        super(message);
    }
}
