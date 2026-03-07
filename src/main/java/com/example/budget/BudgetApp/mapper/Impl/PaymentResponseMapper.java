package com.example.budget.BudgetApp.mapper.Impl;

import com.example.budget.BudgetApp.dto.PaymentResponseDto;
import com.example.budget.BudgetApp.entity.Payment;
import com.example.budget.BudgetApp.mapper.Mapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class PaymentResponseMapper implements Mapper<Payment, PaymentResponseDto> {

    private final ModelMapper modelMapper;

    @Override
    public PaymentResponseDto mapTo(Payment payment) {
        return modelMapper.map(payment, PaymentResponseDto.class);
    }

    @Override
    public Payment mapFrom(PaymentResponseDto paymentResponseDto) {
        return modelMapper.map(paymentResponseDto, Payment.class);
    }
}
