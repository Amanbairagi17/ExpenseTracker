package com.example.budget.BudgetApp.dto;

import com.example.budget.BudgetApp.entity.Group;
import com.example.budget.BudgetApp.entity.User;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PaymentResponseDto {
    private Long transactionId;
    private Long userId;
    private Long groupId;
    private double amount;
    private String paymentDescription;
    private LocalDate paymentDate;
    private LocalDate addedDate;

}
