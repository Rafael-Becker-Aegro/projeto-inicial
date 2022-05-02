package com.projeto_inicial.projeto_inicial.Farm.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class FarmExceptionHandler {
    private FarmException completeFarmException(RuntimeException e, HttpServletRequest request){
        FarmException farmException = new FarmException();
        farmException.setTimestamp(Instant.now());
        farmException.setMessage(e.getMessage());
        farmException.setPath(request.getRequestURI());
        return farmException;
    }

    @ExceptionHandler(FarmNotFoundException.class)
    public ResponseEntity<FarmException> farmNotFound(FarmNotFoundException e, HttpServletRequest request){
        FarmException farmException = completeFarmException(e, request);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(farmException);
    }

    @ExceptionHandler(FarmIncompleteException.class)
    public ResponseEntity<FarmException> farmIncomplete(FarmIncompleteException e, HttpServletRequest request){
        FarmException farmException = completeFarmException(e, request);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(farmException);
    }
}
