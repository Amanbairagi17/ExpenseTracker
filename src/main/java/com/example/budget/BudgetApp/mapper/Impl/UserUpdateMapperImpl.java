package com.example.budget.BudgetApp.mapper.Impl;

import com.example.budget.BudgetApp.dto.UserUpdateRequestDto;
import com.example.budget.BudgetApp.dto.UserUpdateResponseDto;
import com.example.budget.BudgetApp.entity.User;
import com.example.budget.BudgetApp.mapper.UserUpdateMapper;
import org.springframework.stereotype.Component;

@Component
public class UserUpdateMapperImpl implements UserUpdateMapper {
    @Override
    public User toUser(UserUpdateRequestDto userUpdateRequestDto) {
        User user = new User();
        user.setUserName(userUpdateRequestDto.getName());
        user.setAddress(userUpdateRequestDto.getAddress());
        user.setMobileNumber(userUpdateRequestDto.getMobileNumber());
        return user;
    }

    @Override
    public UserUpdateResponseDto fromUser(User user) {
        UserUpdateResponseDto userResponse = new UserUpdateResponseDto();
        userResponse.setUserId(user.getUserId());
        userResponse.setName(user.getUserName());
        userResponse.setAddress(user.getAddress());
        userResponse.setEmail(user.getEmail());
        userResponse.setMobileNumber(user.getMobileNumber());
        return userResponse;
    }
}
