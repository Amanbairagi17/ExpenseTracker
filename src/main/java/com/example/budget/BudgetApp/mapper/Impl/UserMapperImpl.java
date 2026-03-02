package com.example.budget.BudgetApp.mapper.Impl;

import com.example.budget.BudgetApp.dto.UserRequestDto;
import com.example.budget.BudgetApp.dto.UserResponseDto;
import com.example.budget.BudgetApp.entity.User;
import com.example.budget.BudgetApp.mapper.UserMapper;

public class UserMapperImpl implements UserMapper {
    @Override
    public User toUser(UserRequestDto requestDto) {
        User user = new User();
        user.setUserName(requestDto.getName());
        user.setEmail(requestDto.getEmail());
        return user;
    }

    @Override
    public UserResponseDto fromUserDro(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setUserId(user.getUserId());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setName(user.getUserName());
        return userResponseDto;
    }
}
