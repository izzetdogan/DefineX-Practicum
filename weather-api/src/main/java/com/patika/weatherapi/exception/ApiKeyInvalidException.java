package com.patika.weatherapi.exception;

public class ApiKeyInvalidException extends  RuntimeException{
    public ApiKeyInvalidException(String message) {
        super(message);
    }
}
