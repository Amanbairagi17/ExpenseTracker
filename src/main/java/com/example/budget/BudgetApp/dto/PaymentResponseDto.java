package com.example.budget.BudgetApp.dto;

import com.example.budget.BudgetApp.entity.Group;
import com.example.budget.BudgetApp.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PaymentResponseDto {
    @NotBlank
    private Long transactionId;

    @NotBlank
    private Long userId;

    @NotBlank
    private Long groupId;

    @NotBlank
    private double amount;

    @NotEmpty
    private String paymentDescription;

    @NotBlank
    private LocalDate paymentDate;

    @NotBlank
    private LocalDate addedDate;

}
