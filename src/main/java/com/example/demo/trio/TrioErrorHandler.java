package com.example.demo.trio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TrioErrorHandler {

    private static final Logger logger = LoggerFactory.getLogger(TrioErrorHandler.class);


    @ExceptionHandler(InvalidVacantCoordinatesException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public Exception validationError(InvalidVacantCoordinatesException ex) {

        logger.error("Exception : ", ex);
        return ex;
    }

}
