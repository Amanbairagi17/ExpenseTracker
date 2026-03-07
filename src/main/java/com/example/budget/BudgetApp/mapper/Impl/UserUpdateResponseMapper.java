package com.example.budget.BudgetApp.mapper.Impl;

import com.example.budget.BudgetApp.dto.UserUpdateResponseDto;
import com.example.budget.BudgetApp.entity.User;
import com.example.budget.BudgetApp.mapper.Mapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class UserUpdateResponseMapper implements Mapper<User, UserUpdateResponseDto> {

    private final ModelMapper modelMapper;

    @Override
    public UserUpdateResponseDto mapTo(User user) {
        return modelMapper.map(user, UserUpdateResponseDto.class);
    }

    @Override
    public User mapFrom(UserUpdateResponseDto userUpdateResponseDto) {
        return modelMapper.map(userUpdateResponseDto, User.class);
    }
}
