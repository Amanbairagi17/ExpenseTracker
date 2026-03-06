package com.example.budget.BudgetApp.dto;

import com.example.budget.BudgetApp.entity.Group;
import com.example.budget.BudgetApp.entity.User;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
public class PaymentRequestDto {
    private Long userId;
    private Long groupId;
    private double amount;
    private String paymentDescription;
    private LocalDateTime paymentDateTime;
}
