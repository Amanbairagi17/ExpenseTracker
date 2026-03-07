package com.example.budget.BudgetApp.mapper.Impl;

import com.example.budget.BudgetApp.dto.UserRequestDto;
import com.example.budget.BudgetApp.entity.User;
import com.example.budget.BudgetApp.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserRequestMapper implements Mapper<User, UserRequestDto> {
    private final ModelMapper modelMapper;

    @Override
    public UserRequestDto mapTo(User user) {
        return modelMapper.map(user, UserRequestDto.class);
    }

    @Override
    public User mapFrom(UserRequestDto userRequestDto) {
        return modelMapper.map(userRequestDto, User.class);
    }
}
