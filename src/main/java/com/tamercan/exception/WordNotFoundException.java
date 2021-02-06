package com.tamercan.exception;

public class WordNotFoundException extends RuntimeException {

    public WordNotFoundException() {
        super("Word not found");
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
