package com.example.budget.BudgetApp.mapper.Impl;

import com.example.budget.BudgetApp.dto.UserResponseDto;
import com.example.budget.BudgetApp.entity.User;
import com.example.budget.BudgetApp.mapper.Mapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserResponseMapper implements Mapper<User, UserResponseDto> {

    private final ModelMapper modelMapper;

    @Override
    public UserResponseDto mapTo(User user) {
        return modelMapper.map(user, UserResponseDto.class);
    }

    @Override
    public User mapFrom(UserResponseDto userResponseDto) {
        return modelMapper.map(userResponseDto, User.class);
    }
}
