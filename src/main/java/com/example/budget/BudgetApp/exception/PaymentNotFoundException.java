package com.example.budget.BudgetApp.exception;

public class PaymentNotFoundException extends RuntimeException{
    public PaymentNotFoundException(String msg){
        super(msg);
    }
}
