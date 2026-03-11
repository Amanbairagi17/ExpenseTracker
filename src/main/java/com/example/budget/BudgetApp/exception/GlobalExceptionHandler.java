package com.example.budget.BudgetApp.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<String> paymentNotFoundException(PaymentNotFoundException paymentNotFoundException){
        return ResponseEntity.badRequest().body(paymentNotFoundException.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public  ResponseEntity<String> userNotFoundException(UserNotFoundException userNotFoundException){
        return ResponseEntity.badRequest().body(userNotFoundException.getMessage());
    }

    @ExceptionHandler(GroupNotFoundException.class)
    public ResponseEntity<String> groupNotFoundException(GroupNotFoundException groupNotFoundException){
        return ResponseEntity.badRequest().body(groupNotFoundException.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRunTimeException(RuntimeException exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
