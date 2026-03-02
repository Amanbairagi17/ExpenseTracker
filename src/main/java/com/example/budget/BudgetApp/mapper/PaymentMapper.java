package com.example.budget.BudgetApp.mapper;

import com.example.budget.BudgetApp.dto.PaymentResponseDto;
import org.springframework.stereotype.Component;

@Component
public interface PaymentMapper {
    public PaymentResponseDto toPaymentDto();
    public PaymentResponseDto fromPaymentDto();
}
