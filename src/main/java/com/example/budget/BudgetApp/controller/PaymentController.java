package com.example.budget.BudgetApp.controller;

import com.example.budget.BudgetApp.dto.PaymentRequestDto;
import com.example.budget.BudgetApp.dto.PaymentResponseDto;
import com.example.budget.BudgetApp.dto.PaymentUpdateDto;
import com.example.budget.BudgetApp.service.PaymentService;
import jakarta.validation.Valid;
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
    public ResponseEntity<PaymentResponseDto> createPayment(@Valid @RequestBody PaymentRequestDto paymentRequestDto){
        PaymentResponseDto response = paymentService.createPayment(paymentRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<PaymentResponseDto> getPayment(@PathVariable Long paymentId){
        PaymentResponseDto response = paymentService.findPaymentById(paymentId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{paymentId}")
    public ResponseEntity<String> deletePaymentById(@PathVariable Long paymentId){
        String deletedPayment = paymentService.deletePayment(paymentId);
        return ResponseEntity.ok(deletedPayment);
    }

    @PutMapping("/{paymentId}")
    public ResponseEntity<PaymentResponseDto> updatePayment(@PathVariable Long paymentId,
                                                            @Valid @RequestBody PaymentUpdateDto paymentUpdateDto){
        PaymentResponseDto response = paymentService.updateTransaction(paymentId, paymentUpdateDto);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}