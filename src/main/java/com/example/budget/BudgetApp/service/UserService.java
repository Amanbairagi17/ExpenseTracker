package com.example.budget.BudgetApp.service;

import com.example.budget.BudgetApp.dto.UserRequestDto;
import com.example.budget.BudgetApp.dto.UserResponseDto;
import com.example.budget.BudgetApp.dto.UserUpdateRequestDto;

import java.util.List;

public interface UserService {

    UserResponseDto createUser(UserRequestDto userRequestDto);

    UserResponseDto findUserById(Long userId);

    UserResponseDto updateUser(Long userId, UserUpdateRequestDto userUpdateRequestDto);

    String deleteUserById(Long userId);

    List<UserResponseDto> getAllUserByPagination(int page, int size);
}
