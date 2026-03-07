package com.example.budget.BudgetApp.dto;

import lombok.Data;

@Data
public class UserUpdateRequestDto {
    private String userName;
    private String address;
    private String mobileNumber;
}
