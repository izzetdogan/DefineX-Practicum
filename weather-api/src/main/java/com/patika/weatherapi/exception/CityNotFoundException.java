package com.patika.weatherapi.exception;

public class CityNotFoundException extends  RuntimeException{
    public CityNotFoundException(String message) {
        super(message);
    }
}
