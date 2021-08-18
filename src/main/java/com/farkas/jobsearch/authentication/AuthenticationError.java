package com.farkas.jobsearch.authentication;

public class AuthenticationError {

    private String message;

    public AuthenticationError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
