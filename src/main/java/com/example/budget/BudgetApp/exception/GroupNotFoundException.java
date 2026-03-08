package com.example.budget.BudgetApp.exception;

public class GroupNotFoundException extends RuntimeException{
    public GroupNotFoundException(String msg){
        super(msg);
    }
}
