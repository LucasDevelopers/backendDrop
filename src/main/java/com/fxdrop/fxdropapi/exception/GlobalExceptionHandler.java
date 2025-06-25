package com.fxdrop.fxdropapi.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
                .body("Erro no usuário: " + ex.getMessage());
    }

    @ExceptionHandler(CompanyException.class)
    public ResponseEntity<String> handleCompanyException(CompanyException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na empresa: " + ex.getMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity exceptionError404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity exceptionError400(MethodArgumentNotValidException ex){
        var errors = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(errorsValidate::new).toList());
    }

    private record errorsValidate(String object, String message){
        public errorsValidate(FieldError erro){
            this(erro.getField(), erro.getDefaultMessage());
        }
    }
}
