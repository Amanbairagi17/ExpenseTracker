package com.example.budget.BudgetApp.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserResponseDto {
    private int userId;
    private String name;
    private String email;
}
