package com.example.budget.BudgetApp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequestDto {
    @NotEmpty(message = "User name required") @Size(min = 4, max = 20)
    private String userName;

    @Email(message = "Please enter valid email")
    private String email;
}
