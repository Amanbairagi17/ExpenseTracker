package com.example.budget.BudgetApp.mapper.Impl;

import com.example.budget.BudgetApp.dto.PaymentRequestDto;
import com.example.budget.BudgetApp.dto.PaymentResponseDto;
import com.example.budget.BudgetApp.entity.Payment;
import com.example.budget.BudgetApp.mapper.PaymentMapper;

public class PaymentMapperImpl implements PaymentMapper {
    @Override
    public Payment toPaymentDto(PaymentRequestDto paymentRequestDto) {
        Payment payment = new Payment();
        payment.setUser(paymentRequestDto.getUserId());
        payment.setGroup(paymentRequestDto.getGroupId());
        payment.setAmount(paymentRequestDto.getAmount());
        payment.setPaymentDescription(paymentRequestDto.getPaymentDescription());
        payment.setPaymentDateTime(paymentRequestDto.getPaymentDateTime());
        return payment;
    }

    @Override
    public PaymentResponseDto fromPaymentDto(Payment payment) {
        PaymentResponseDto paymentResponseDto = new PaymentResponseDto();
        paymentResponseDto.setTransactionId(payment.getTransactionId());
        paymentResponseDto.setUserId(payment.getUser());
        paymentResponseDto.setGroupId(payment.getGroup());
        paymentResponseDto.setAmount(payment.getAmount());
        paymentResponseDto.setPaymentDescription(paymentResponseDto.getPaymentDescription());
        paymentResponseDto.setPaymentDateTime(payment.getPaymentDateTime());
        paymentResponseDto.setAddedDateTime(payment.getCreatedAt());
        return paymentResponseDto;
    }
}
