package com.example.budget.BudgetApp.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {
    public LocalDateTime timeStamp;
    public int status;
    public String error;
    public String message;
}
