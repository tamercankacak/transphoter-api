package com.tamercan.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String name) {
        super("User not found in this name :"+name);
    }

    @Override
    public String getLocalizedMessage() {
        return super.getLocalizedMessage();
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
