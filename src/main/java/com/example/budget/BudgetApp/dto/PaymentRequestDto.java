package com.example.budget.BudgetApp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PaymentRequestDto {
    @NotBlank
    private Long userId;

    @NotBlank
    private Long groupId;

    @NotBlank
    private double amount;

    @NotEmpty
    private String paymentDescription;

    @NotEmpty
    private LocalDate paymentDate;
}
