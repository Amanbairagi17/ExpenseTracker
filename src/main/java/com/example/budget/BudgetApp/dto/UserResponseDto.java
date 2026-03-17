package com.example.budget.BudgetApp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserResponseDto {
    @NotBlank
    private Long userId;

    @NotEmpty(message = "User name require") @Size(min = 4, max = 20)
    private String userName;

    @NotEmpty(message = "Enter Address")
    private String address;

}
