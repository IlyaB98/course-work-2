package com.example.coursework2.exceptions;

public class QuestionNotFoundException extends RuntimeException{
    public QuestionNotFoundException() {
    }

    public QuestionNotFoundException(String message) {
        super(message);
    }
}
