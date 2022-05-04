package com.projeto_inicial.projeto_inicial.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class GenericExceptionHandler {
    private GenericException completeGenericException(RuntimeException e, HttpServletRequest request){
        GenericException genericException = new GenericException();
        genericException.setTimestamp(Instant.now());
        genericException.setMessage(e.getMessage());
        genericException.setPath(request.getRequestURI());
        return genericException;
    }

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<GenericException> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
        GenericException genericException = completeGenericException(e, request);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(genericException);
    }

    @ExceptionHandler(ObjectIncompleteException.class)
    public ResponseEntity<GenericException> objectIncomplete(ObjectIncompleteException e, HttpServletRequest request){
        GenericException genericException = completeGenericException(e, request);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(genericException);
    }
}
