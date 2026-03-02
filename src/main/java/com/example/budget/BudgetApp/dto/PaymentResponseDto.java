package com.example.budget.BudgetApp.dto;

import com.example.budget.BudgetApp.entity.Group;
import com.example.budget.BudgetApp.entity.User;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class PaymentResponseDto {
    private int transactionId;
    private User userId;
    private Group groupId;
    private double amount;
    private String paymentDescription;
    private LocalDateTime paymentDateTime;
    private LocalDateTime addedDateTime;

}
