package com.andres.curso.springboot.error.springboot_error.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.andres.curso.springboot.error.springboot_error.models.Error;

@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler({ ArithmeticException.class })
    public ResponseEntity<Error> divisionByZero(Exception ex) {
        Error error = new Error();
        error.setDate(new Date());
        error.setError("Error dividiendo por cero !!");
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        // return ResponseEntity.internalServerError().body(error);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Error> notFoundEx(NoHandlerFoundException e) {
        Error error = new Error();
        error.setDate(new Date());
        error.setError("Api reest No encontrada");
        error.setMessage(e.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        // return ResponseEntity.internalServerError().body(error);
        return ResponseEntity.status(404).body(error);
    }

}
