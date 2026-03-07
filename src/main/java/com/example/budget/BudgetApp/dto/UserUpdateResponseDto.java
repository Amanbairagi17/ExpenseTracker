package com.example.budget.BudgetApp.dto;


import lombok.Data;

@Data
public class UserUpdateResponseDto {
    private Long userId;
    private String userName;
    private String address;
    private String email;
    private String mobileNumber;
}
