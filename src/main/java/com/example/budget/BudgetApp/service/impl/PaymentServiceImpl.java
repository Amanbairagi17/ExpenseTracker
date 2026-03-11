package com.example.budget.BudgetApp.service.impl;

import com.example.budget.BudgetApp.dto.PaymentRequestDto;
import com.example.budget.BudgetApp.dto.PaymentResponseDto;
import com.example.budget.BudgetApp.entity.Group;
import com.example.budget.BudgetApp.entity.Payment;
import com.example.budget.BudgetApp.entity.User;
import com.example.budget.BudgetApp.exception.GroupNotFoundException;
import com.example.budget.BudgetApp.exception.PaymentNotFoundException;
import com.example.budget.BudgetApp.exception.UserNotFoundException;
import com.example.budget.BudgetApp.mapper.Impl.PaymentRequestMapper;
import com.example.budget.BudgetApp.mapper.Impl.PaymentResponseMapper;
import com.example.budget.BudgetApp.repository.GroupRepository;
import com.example.budget.BudgetApp.repository.PaymentRepository;
import com.example.budget.BudgetApp.repository.UserRepository;
import com.example.budget.BudgetApp.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentResponseMapper paymentResponseMapper;
    private final PaymentRequestMapper paymentRequestMapper;
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;

    @Override
    public PaymentResponseDto createPayment(PaymentRequestDto paymentRequestDto) {
        validatePaymentRequest(paymentRequestDto);

        User user = userRepository.findById(paymentRequestDto.getUserId()).orElse(null);
        Group group = groupRepository.findById(paymentRequestDto.getGroupId()).orElse(null);

        Payment payment = paymentRequestMapper.mapFrom(paymentRequestDto);
        Payment savedPayment = paymentRepository.save(payment);
        PaymentResponseDto response = paymentResponseMapper.mapTo(savedPayment);

        response.setUserId(getUserID(paymentRequestDto));
        response.setGroupId(group.getGroupId());
        response.setAddedDate(payment.getCreatedAt());

        return response;
    }



    public PaymentResponseDto findPaymentById(Long paymentId){
        Payment payment = paymentRepository.findById(paymentId).orElseThrow(() -> new PaymentNotFoundException("Payment not exist!"));
        PaymentResponseDto response = paymentResponseMapper.mapTo(payment);

        return response;

    }

    private void validatePaymentRequest(PaymentRequestDto paymentRequestDto) {
        if(!userRepository.existsById(paymentRequestDto.getUserId())) {
            throw new UserNotFoundException("Invalid userId in payment request, User does not exist!!");
        }

        if(!groupRepository.existsById(paymentRequestDto.getGroupId())) {
            throw new GroupNotFoundException("Invalid groupId in payment request, Group not exist!!");
        }
    }

    private Long getUserID(PaymentRequestDto paymentRequestDto){
        User user = userRepository.findById(paymentRequestDto.getUserId()).orElseThrow(() -> new UserNotFoundException("User not found exception !!"));
        return user.getUserId();
    }

    private Long getGroupID(PaymentRequestDto paymentRequestDto){
        Group group = groupRepository.findById(paymentRequestDto.getGroupId()).orElseThrow(() -> new GroupNotFoundException("Group not found !!"));
        return group.getGroupId();
    }


}
