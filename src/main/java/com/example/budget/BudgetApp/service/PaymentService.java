package com.example.budget.BudgetApp.service;

import com.example.budget.BudgetApp.dto.PaymentRequestDto;
import com.example.budget.BudgetApp.dto.PaymentResponseDto;
import com.example.budget.BudgetApp.dto.PaymentUpdateDto;

public interface PaymentService {
    PaymentResponseDto createPayment(PaymentRequestDto paymentRequestDto);

    PaymentResponseDto findPaymentById(Long paymentId);

    String deletePayment(Long paymentId);

    PaymentResponseDto updateTransaction(Long paymentId, PaymentUpdateDto paymentUpdateDto);
}
