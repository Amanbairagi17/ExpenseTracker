package com.example.budget.BudgetApp.controller;

import com.example.budget.BudgetApp.dto.LoginDto;
import com.example.budget.BudgetApp.dto.SignupDto;
import com.example.budget.BudgetApp.dto.UserResponseDto;
import com.example.budget.BudgetApp.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "auth")
@RequiredArgsConstructor
@Tag(name = "Auth Controller", description = "Controller for authorizing users")
public class AuthController {

    private final AuthService authService;
    private static final Logger logger =  LoggerFactory.getLogger(UserController.class);

    @PostMapping
    @Operation(summary = "create user and register yourself")
    public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody SignupDto userRequestDto){

        logger.info("Call user service for creating user");
        UserResponseDto userResponseDto = authService.createUser(userRequestDto);

        logger.info("return response of created user with id");
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDto);
    }

    @PostMapping("/login")
    @Operation(summary = "Login user in application")
    public String login(@Valid @RequestBody LoginDto user){
        return authService.verifyUser(user);
    }
}
