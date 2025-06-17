package com.fxdrop.fxdropapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LoginException.class)
    public ResponseEntity<String> handleLoginException(LoginException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Erro de login: " + ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAllExceptions(Exception ex) {
        ex.printStackTrace(); // para logar no console/log
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Erro: " + ex.getMessage());
    }

    @ExceptionHandler(CreateUserException.class)
    public ResponseEntity<String> handleCreateUserException(CreateUserException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Erro ao criar usuário: " + ex.getMessage());
    }
}
