package com.patika.weatherapi.exception;


public class ParamRequiredException extends  RuntimeException {
    public ParamRequiredException(String message) {
        super(message);
    }
}
