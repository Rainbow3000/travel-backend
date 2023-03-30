package com.example.TravelSpringBootProject.exception;
public class DuplicateException extends RuntimeException{
    public DuplicateException(String message){
        super(message);
    }
}
