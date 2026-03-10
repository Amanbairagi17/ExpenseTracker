package com.example.budget.BudgetApp.controller;


import com.example.budget.BudgetApp.dto.UserRequestDto;
import com.example.budget.BudgetApp.dto.UserResponseDto;
import com.example.budget.BudgetApp.dto.UserUpdateRequestDto;
import com.example.budget.BudgetApp.helper.AppConstant;
import com.example.budget.BudgetApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("check")
    public String user(){
        return "First user of this app";
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUser(@RequestParam(value = "page", defaultValue = AppConstant.DEFAULT_PAGE) int page,
                                                            @RequestParam(value = "size", defaultValue = AppConstant.DEFAULT_SIZE) int size){

        List<UserResponseDto> users = userService.getAllUserByPagination(page, size);

        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Long userId){
        UserResponseDto userResponseDto = userService.findUserById(userId);
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto){
        UserResponseDto userResponseDto = userService.createUser(userRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDto);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable Long userId,
                                                            @RequestBody UserUpdateRequestDto userUpdateRequestDto){
        UserResponseDto userUpdateResponseDto = userService.updateUser(userId, userUpdateRequestDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userUpdateResponseDto);
    }

    @DeleteMapping("delete/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId){
        String deletedUser = userService.deleteUserById(userId);
        return ResponseEntity.ok(deletedUser);

    }
}
