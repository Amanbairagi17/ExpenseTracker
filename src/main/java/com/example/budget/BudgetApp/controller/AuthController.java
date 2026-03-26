package com.example.budget.BudgetApp.controller;

import com.example.budget.BudgetApp.dto.UserRequestDto;
import com.example.budget.BudgetApp.dto.UserResponseDto;
import com.example.budget.BudgetApp.service.UserService;
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

    private final UserService userService;
    private static final Logger logger =  LoggerFactory.getLogger(UserController.class);

    @PostMapping
    @Operation(summary = "create user and register yourself")
    public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody UserRequestDto userRequestDto){

        logger.info("Call user service for creating user");
        UserResponseDto userResponseDto = userService.createUser(userRequestDto);

        logger.info("return response of created user with id");
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDto);
    }

    @PostMapping("/login")
    @Operation(summary = "Login user in application")
    public String login(@Valid @RequestBody UserRequestDto user){
        return userService.verifyUser(user);
    }
}
