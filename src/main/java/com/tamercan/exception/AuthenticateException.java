package com.tamercan.exception;

public class AuthenticateException  extends RuntimeException{

    public AuthenticateException() {
        super("Username or password is wrong. ");
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
