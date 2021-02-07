package com.tamercan.exception;

public class WordAlreadyExistsException extends RuntimeException{

    public WordAlreadyExistsException(String englishword) {
        super("Word " + englishword + " is already exists");
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
