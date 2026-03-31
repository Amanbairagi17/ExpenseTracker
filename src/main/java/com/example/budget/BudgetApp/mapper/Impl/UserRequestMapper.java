package com.example.budget.BudgetApp.mapper.Impl;

import com.example.budget.BudgetApp.dto.SignupDto;
import com.example.budget.BudgetApp.entity.User;
import com.example.budget.BudgetApp.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserRequestMapper implements Mapper<User, SignupDto> {
    private final ModelMapper modelMapper;

    @Override
    public SignupDto mapTo(User user) {
        return modelMapper.map(user, SignupDto.class);
    }

    @Override
    public User mapFrom(SignupDto userRequestDto) {
        return modelMapper.map(userRequestDto, User.class);
    }
}
