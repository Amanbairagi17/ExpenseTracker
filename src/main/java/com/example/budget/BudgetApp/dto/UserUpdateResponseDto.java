package com.example.budget.BudgetApp.dto;


import lombok.Data;

@Data
public class UserUpdateResponseDto {
    private Long userId;
    private String name;
    private String address;
    private String email;
    private String mobileNumber;
}
