package com.example.budget.BudgetApp.service.impl;

import com.example.budget.BudgetApp.dto.LoginDto;
import com.example.budget.BudgetApp.dto.SignupDto;
import com.example.budget.BudgetApp.dto.UserResponseDto;
import com.example.budget.BudgetApp.entity.User;
import com.example.budget.BudgetApp.mapper.Impl.UserRequestMapper;
import com.example.budget.BudgetApp.mapper.Impl.UserResponseMapper;
import com.example.budget.BudgetApp.repository.UserRepository;
import com.example.budget.BudgetApp.service.AuthService;
import com.example.budget.BudgetApp.service.JWTService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final JWTService jwtService;
    private final AuthenticationManager authManager;
    private final UserRequestMapper userRequestMapper;
    private final UserResponseMapper userResponseMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public String verifyUser(LoginDto user) {
        log.info(user.toString());
        Authentication authentication = authManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
        if(authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getEmail());
        }

        return "Login Failed";
    }

    @Override
    public UserResponseDto createUser(SignupDto userRequestDto) {
        boolean exists = userRepository.existsByEmail(userRequestDto.getEmail());

        if(exists)
            throw new RuntimeException("User already exists");
        User user =  userRequestMapper.mapFrom(userRequestDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);
        return userResponseMapper.mapTo(savedUser);
    }

}

