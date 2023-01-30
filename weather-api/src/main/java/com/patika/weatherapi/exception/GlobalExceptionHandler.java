package com.patika.weatherapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(CityNotFoundException.class)
    public ResponseEntity<?> cityNotFoundHandler(CityNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ParamRequiredException.class)
    public ResponseEntity<?> paramRequiredHandler(ParamRequiredException exception){
        return  new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ApiKeyInvalidException.class)
    public ResponseEntity<?> paramRequiredHandler(ApiKeyInvalidException exception){
        return  new ResponseEntity<>(exception.getMessage(),HttpStatus.FORBIDDEN);
    }


}
