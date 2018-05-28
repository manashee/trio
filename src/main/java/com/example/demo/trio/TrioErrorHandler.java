package com.example.demo.trio;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TrioErrorHandler {

    @ExceptionHandler(InvalidVacantCoordinatesException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public Exception validationError(InvalidVacantCoordinatesException ex) {

        return ex;
    }

}
