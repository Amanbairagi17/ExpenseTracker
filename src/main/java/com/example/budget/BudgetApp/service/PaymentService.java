package com.example.budget.BudgetApp.service;

import com.example.budget.BudgetApp.dto.PaymentRequestDto;
import com.example.budget.BudgetApp.dto.PaymentResponseDto;

public interface PaymentService {
    PaymentResponseDto createPayment(PaymentRequestDto paymentRequestDto);

    PaymentResponseDto findPaymentById(Long paymentId);
}
