package com.example.budget.BudgetApp.service.impl;

import com.example.budget.BudgetApp.dto.UserRequestDto;
import com.example.budget.BudgetApp.dto.UserResponseDto;
import com.example.budget.BudgetApp.dto.UserUpdateRequestDto;
import com.example.budget.BudgetApp.dto.UserUpdateResponseDto;
import com.example.budget.BudgetApp.entity.User;
import com.example.budget.BudgetApp.exception.UserNotFoundException;
import com.example.budget.BudgetApp.mapper.Impl.UserResponseMapper;
import com.example.budget.BudgetApp.mapper.Impl.UserUpdateResponseMapper;
import com.example.budget.BudgetApp.mapper.Mapper;
import com.example.budget.BudgetApp.repository.UserRepository;
import com.example.budget.BudgetApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final Mapper<User, UserRequestDto> userRequestMapper;
    private final UserResponseMapper userResponseMapper;
    private final UserUpdateResponseMapper userUpdateResponseMapper;
    @Override
    public UserUpdateResponseDto updateUser(Long userId, UserUpdateRequestDto userUpdateRequestDto) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User Not Found with Id " + userId));
        user.setUserName(userUpdateRequestDto.getUserName());
        user.setMobileNumber(userUpdateRequestDto.getMobileNumber());
        user.setAddress(userUpdateRequestDto.getAddress());
        User updatedUser = userRepository.save(user);
        return userUpdateResponseMapper.mapTo(updatedUser);
    }

    @Override
    public UserResponseDto findUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User Not Found with Id " + userId));
        return userResponseMapper.mapTo(user);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepository.getAllUsers();
        return users;
    }

    @Override
    public String deleteUserById(Long userId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User Not Exist!!"));
        userRepository.deleteById(userId);

        return "User deleted successfully with ID " + userId;
    }

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User user =  userRequestMapper.mapFrom(userRequestDto);
        User savedUser = userRepository.save(user);
        return userResponseMapper.mapTo(savedUser);
    }
}
