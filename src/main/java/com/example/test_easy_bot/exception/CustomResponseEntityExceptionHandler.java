package com.example.test_easy_bot.exception;

import lombok.extern.java.Log;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Log
@RestControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductIsNotFoundException.class)
    public ResponseEntity<Object> handleForbiddenException(Exception e, WebRequest request) {
        logger.error(e.getMessage());
        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.FORBIDDEN, request);
    }

    @ExceptionHandler(value = {Exception.class, RuntimeException.class})
    public ResponseEntity<Object> handleException(Exception e) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
