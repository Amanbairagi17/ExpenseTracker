package com.example.budget.BudgetApp.mapper.Impl;

import com.example.budget.BudgetApp.dto.PaymentRequestDto;
import com.example.budget.BudgetApp.dto.PaymentResponseDto;
import com.example.budget.BudgetApp.entity.Payment;
import com.example.budget.BudgetApp.mapper.PaymentMapper;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapperImpl implements PaymentMapper {
    @Override
    public Payment toPaymentDto(PaymentRequestDto paymentRequestDto) {
        Payment payment = new Payment();

        payment.setAmount(paymentRequestDto.getAmount());
        payment.setPaymentDescription(paymentRequestDto.getPaymentDescription());
        payment.setPaymentDateTime(paymentRequestDto.getPaymentDateTime());

        return payment;
    }

    @Override
    public PaymentResponseDto fromPaymentDto(Payment payment) {
        PaymentResponseDto paymentResponseDto = new PaymentResponseDto();
        paymentResponseDto.setTransactionId(payment.getTransactionId());
        paymentResponseDto.setUserId(payment.getUser().getUserName());
        paymentResponseDto.setGroupId(payment.getGroup().getGroupName());
        paymentResponseDto.setAmount(payment.getAmount());
        paymentResponseDto.setPaymentDescription(paymentResponseDto.getPaymentDescription());
        paymentResponseDto.setPaymentDateTime(payment.getPaymentDateTime());
        paymentResponseDto.setAddedDateTime(payment.getCreatedAt());
        return paymentResponseDto;
    }
}
