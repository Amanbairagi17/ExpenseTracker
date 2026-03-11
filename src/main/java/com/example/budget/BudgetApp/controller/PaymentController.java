package com.example.budget.BudgetApp.controller;

import com.example.budget.BudgetApp.dto.PaymentRequestDto;
import com.example.budget.BudgetApp.dto.PaymentResponseDto;
import com.example.budget.BudgetApp.mapper.Impl.PaymentRequestMapper;
import com.example.budget.BudgetApp.mapper.Impl.PaymentResponseMapper;
import com.example.budget.BudgetApp.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<PaymentResponseDto> createPayment(@RequestBody PaymentRequestDto paymentRequestDto){
        PaymentResponseDto response = paymentService.createPayment(paymentRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<PaymentResponseDto> getPayment(@PathVariable Long paymentId){
        PaymentResponseDto response = paymentService.findPaymentById(paymentId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
