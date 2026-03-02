package com.example.budget.BudgetApp.mapper;

import com.example.budget.BudgetApp.dto.UserRequestDto;
import com.example.budget.BudgetApp.dto.UserResponseDto;
import com.example.budget.BudgetApp.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {
    public User toUser(UserRequestDto user);
    public UserResponseDto fromUserDro(User u);
}
