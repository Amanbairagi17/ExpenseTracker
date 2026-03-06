package com.example.budget.BudgetApp.service;

import com.example.budget.BudgetApp.dto.UserRequestDto;
import com.example.budget.BudgetApp.dto.UserResponseDto;
import com.example.budget.BudgetApp.dto.UserUpdateRequestDto;
import com.example.budget.BudgetApp.dto.UserUpdateResponseDto;
import org.springframework.stereotype.Service;

public interface UserService {

    UserResponseDto createUser(UserRequestDto userRequestDto);

    UserResponseDto findUserById(Long userId);

    UserUpdateResponseDto updateUser(Long userId, UserUpdateRequestDto userUpdateRequestDto);
}
