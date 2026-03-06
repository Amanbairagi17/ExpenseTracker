package com.example.budget.BudgetApp.dto;

import com.example.budget.BudgetApp.entity.Group;
import com.example.budget.BudgetApp.entity.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PaymentResponseDto {
    private Long transactionId;
    private String userId;
    private String groupId;
    private double amount;
    private String paymentDescription;
    private LocalDateTime paymentDateTime;
    private LocalDateTime addedDateTime;

}
