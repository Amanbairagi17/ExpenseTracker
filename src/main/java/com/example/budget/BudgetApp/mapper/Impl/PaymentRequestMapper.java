package com.example.budget.BudgetApp.mapper.Impl;

import com.example.budget.BudgetApp.dto.PaymentRequestDto;
import com.example.budget.BudgetApp.dto.PaymentResponseDto;
import com.example.budget.BudgetApp.entity.Payment;
import com.example.budget.BudgetApp.mapper.Mapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class PaymentRequestMapper implements Mapper<Payment, PaymentRequestDto> {

    private final ModelMapper modelMapper;

    @Override
    public PaymentRequestDto mapTo(Payment payment) {
        return modelMapper.map(payment, PaymentRequestDto.class);
    }

    @Override
    public Payment mapFrom(PaymentRequestDto paymentRequestDto) {
        return modelMapper.map(paymentRequestDto, Payment.class);
    }
}
