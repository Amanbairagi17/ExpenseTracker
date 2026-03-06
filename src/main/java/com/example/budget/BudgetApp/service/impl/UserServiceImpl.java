package com.example.budget.BudgetApp.service.impl;

import com.example.budget.BudgetApp.dto.UserRequestDto;
import com.example.budget.BudgetApp.dto.UserResponseDto;
import com.example.budget.BudgetApp.entity.User;
import com.example.budget.BudgetApp.mapper.UserMapper;
import com.example.budget.BudgetApp.repository.UserRepository;
import com.example.budget.BudgetApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User user =  userMapper.toUser(userRequestDto);
        User savedUser = userRepository.save(user);
        return userMapper.fromUserDto(savedUser);
    }
}
