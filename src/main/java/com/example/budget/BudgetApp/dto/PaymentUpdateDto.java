package com.example.budget.BudgetApp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PaymentUpdateDto {
    @NotEmpty
    private String paymentDescription;

    @NotBlank
    private LocalDate paymentDate;
}
