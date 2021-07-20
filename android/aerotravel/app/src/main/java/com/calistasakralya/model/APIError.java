package com.calistasakralya.model;

public class APIError {
    private final String message;

    public APIError(String message) {
        this.message = message;
    }
    public String message() {
        return message;
    }
}
