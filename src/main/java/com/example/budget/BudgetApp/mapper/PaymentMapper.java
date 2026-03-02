package com.example.budget.BudgetApp.mapper;

import com.example.budget.BudgetApp.dto.PaymentRequestDto;
import com.example.budget.BudgetApp.dto.PaymentResponseDto;
import com.example.budget.BudgetApp.entity.Payment;
import org.springframework.stereotype.Component;

@Component
public interface PaymentMapper {
    public Payment toPaymentDto(PaymentRequestDto paymentRequestDto);
    public PaymentResponseDto fromPaymentDto(Payment payment);
}
