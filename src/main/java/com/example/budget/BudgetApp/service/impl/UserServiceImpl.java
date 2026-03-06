package com.example.budget.BudgetApp.service.impl;

import com.example.budget.BudgetApp.dto.UserRequestDto;
import com.example.budget.BudgetApp.dto.UserResponseDto;
import com.example.budget.BudgetApp.dto.UserUpdateRequestDto;
import com.example.budget.BudgetApp.dto.UserUpdateResponseDto;
import com.example.budget.BudgetApp.entity.User;
import com.example.budget.BudgetApp.exception.UserNotFoundException;
import com.example.budget.BudgetApp.mapper.UserMapper;
import com.example.budget.BudgetApp.mapper.UserUpdateMapper;
import com.example.budget.BudgetApp.repository.UserRepository;
import com.example.budget.BudgetApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserUpdateMapper userUpdateMapper;

    @Override
    public UserUpdateResponseDto updateUser(Long userId, UserUpdateRequestDto userUpdateRequestDto) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User Not Found with Id " + userId));
        user.setUserName(userUpdateRequestDto.getName());
        user.setMobileNumber(userUpdateRequestDto.getMobileNumber());
        user.setAddress(userUpdateRequestDto.getAddress());
        User updatedUser = userRepository.save(user);
        return userUpdateMapper.fromUser(updatedUser);
    }

    @Override
    public UserResponseDto findUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User Not Found with Id " + userId));
        return userMapper.fromUserDto(user);
    }

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User user =  userMapper.toUser(userRequestDto);
        User savedUser = userRepository.save(user);
        return userMapper.fromUserDto(savedUser);
    }
}
