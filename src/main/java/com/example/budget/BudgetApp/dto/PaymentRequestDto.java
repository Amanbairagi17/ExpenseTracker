package com.example.budget.BudgetApp.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PaymentRequestDto {
    private Long userId;
    private Long groupId;
    private double amount;
    private String paymentDescription;
    private LocalDate paymentDate;
}
