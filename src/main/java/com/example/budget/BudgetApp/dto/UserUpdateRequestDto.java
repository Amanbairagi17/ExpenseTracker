package com.example.budget.BudgetApp.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserUpdateRequestDto {

    @NotEmpty(message = "User name required")
    private String userName;

    @NotEmpty(message = "Enter Address")
    private String address;

    @NotEmpty(message = "Please Enter Mobile Number")
    private String mobileNumber;
}
