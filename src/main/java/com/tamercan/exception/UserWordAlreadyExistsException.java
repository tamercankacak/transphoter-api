package com.tamercan.exception;

public class UserWordAlreadyExistsException extends RuntimeException {

    public UserWordAlreadyExistsException() {
        super("UserWord is already exists");
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
