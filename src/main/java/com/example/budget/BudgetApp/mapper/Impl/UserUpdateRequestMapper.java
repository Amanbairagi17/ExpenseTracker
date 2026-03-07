package com.example.budget.BudgetApp.mapper.Impl;

import com.example.budget.BudgetApp.dto.UserUpdateRequestDto;
import com.example.budget.BudgetApp.entity.User;
import com.example.budget.BudgetApp.mapper.Mapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class UserUpdateRequestMapper implements Mapper<User, UserUpdateRequestDto> {

    private final ModelMapper modelMapper;
    @Override
    public UserUpdateRequestDto mapTo(User user) {
        return modelMapper.map(user, UserUpdateRequestDto.class);
    }

    @Override
    public User mapFrom(UserUpdateRequestDto userUpdateRequestDto) {
        return modelMapper.map(userUpdateRequestDto, User.class);
    }
}
