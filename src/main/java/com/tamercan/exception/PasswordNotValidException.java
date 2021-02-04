package com.tamercan.exception;

public class PasswordNotValidException extends RuntimeException {

    public PasswordNotValidException() {
        super("Password is incorrect.");
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
