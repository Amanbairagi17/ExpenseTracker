package com.example.budget.BudgetApp.service.impl;

import com.example.budget.BudgetApp.dto.UserRequestDto;
import com.example.budget.BudgetApp.dto.UserResponseDto;
import com.example.budget.BudgetApp.dto.UserUpdateRequestDto;
import com.example.budget.BudgetApp.entity.User;
import com.example.budget.BudgetApp.exception.UserNotFoundException;
import com.example.budget.BudgetApp.mapper.Impl.UserResponseMapper;
import com.example.budget.BudgetApp.mapper.Impl.UserUpdateRequestMapper;
import com.example.budget.BudgetApp.mapper.Mapper;
import com.example.budget.BudgetApp.repository.UserRepository;
import com.example.budget.BudgetApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final Mapper<User, UserRequestDto> userRequestMapper;
    private final UserResponseMapper userResponseMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<UserResponseDto> getAllUserByPagination(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.ASC, "userName");
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<User> users = userRepository.findAll(pageable);

        List<UserResponseDto> userResponse = users.stream()
                .map(userResponseMapper::mapTo)
                .collect(Collectors.toList());
        return userResponse;
    }

    private final UserUpdateRequestMapper userUpdateRequestMapper;

    @Override
    public UserResponseDto updateUser(Long userId, UserUpdateRequestDto userUpdateRequestDto) {

        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User Not Found with Id " + userId));
        User updateUser = userUpdateRequestMapper.mapFrom(userUpdateRequestDto);
        updateUser.setUserId(user.getUserId());
        updateUser.setEmail(user.getEmail());

        User saveedUser = userRepository.save(updateUser);
        return userResponseMapper.mapTo(saveedUser);
    }

    @Override
    public UserResponseDto findUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User Not Found with Id " + userId));
        return userResponseMapper.mapTo(user);
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
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);
        return userResponseMapper.mapTo(savedUser);
    }
}
