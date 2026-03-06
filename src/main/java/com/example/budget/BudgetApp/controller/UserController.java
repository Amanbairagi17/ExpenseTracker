package com.example.budget.BudgetApp.controller;


import com.example.budget.BudgetApp.dto.UserRequestDto;
import com.example.budget.BudgetApp.dto.UserResponseDto;
import com.example.budget.BudgetApp.dto.UserUpdateRequestDto;
import com.example.budget.BudgetApp.dto.UserUpdateResponseDto;
import com.example.budget.BudgetApp.mapper.UserUpdateMapper;
import com.example.budget.BudgetApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public String user(){
        return "First user of this app";
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Long userId){
        UserResponseDto userResponseDto = userService.findUserById(userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDto);
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto){
        UserResponseDto userResponseDto = userService.createUser(userRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDto);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<UserUpdateResponseDto> updateUser(@PathVariable Long userId,
                                                            @RequestBody UserUpdateRequestDto userUpdateRequestDto){
        UserUpdateResponseDto userUpdateResponseDto = userService.updateUser(userId, userUpdateRequestDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userUpdateResponseDto);
    }
}
