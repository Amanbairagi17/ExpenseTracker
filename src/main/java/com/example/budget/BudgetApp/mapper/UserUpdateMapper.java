package com.example.budget.BudgetApp.mapper;


import com.example.budget.BudgetApp.dto.UserUpdateRequestDto;
import com.example.budget.BudgetApp.dto.UserUpdateResponseDto;
import com.example.budget.BudgetApp.entity.User;
import org.springframework.stereotype.Component;


public interface UserUpdateMapper {

    public User toUser(UserUpdateRequestDto userUpdateRequestDto);
    public UserUpdateResponseDto fromUser(User user);

}
