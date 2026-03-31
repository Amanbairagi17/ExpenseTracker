package com.example.budget.BudgetApp.service;

import com.example.budget.BudgetApp.dto.LoginDto;
import com.example.budget.BudgetApp.dto.SignupDto;
import com.example.budget.BudgetApp.dto.UserResponseDto;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    String verifyUser(LoginDto user);

    UserResponseDto createUser(SignupDto userRequestDto);

}
