package com.example.demo.ControllerAdvice;

public class APIException extends RuntimeException {
    public APIException() {
    }
    public APIException(String message){
        super(message);
    }
}
