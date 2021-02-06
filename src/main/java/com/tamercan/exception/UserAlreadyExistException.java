package com.tamercan.exception;

public class UserAlreadyExistException extends RuntimeException {

    public UserAlreadyExistException(String username) {
        super("Username " + username + " is already exist");
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
