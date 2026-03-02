package com.example.budget.BudgetApp.dto;

import java.time.LocalDateTime;

public class PaymentResponseDto {
    private int transactionId;
    private int userId;
    private int groupId;
    private double amount;
    private String paymentDescription;
    private LocalDateTime paymentDateTime;
    private LocalDateTime addedDateTime;

}
