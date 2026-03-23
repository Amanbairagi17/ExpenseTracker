package com.example.budget.BudgetApp.controller;


import com.example.budget.BudgetApp.dto.UserRequestDto;
import com.example.budget.BudgetApp.dto.UserResponseDto;
import com.example.budget.BudgetApp.dto.UserUpdateRequestDto;
import com.example.budget.BudgetApp.helper.AppConstant;
import com.example.budget.BudgetApp.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private static final Logger logger =  LoggerFactory.getLogger(UserController.class);

    @GetMapping("check")
    public String user(HttpServletRequest request){
        logger.info("Health check endpoint called");
        return "First user of this app with session Id : " +request.getSession().getId();
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUser(@RequestParam(value = "page", defaultValue = AppConstant.DEFAULT_PAGE) int page,
                                                            @RequestParam(value = "size", defaultValue = AppConstant.DEFAULT_SIZE) int size){

        logger.info("Fetching users with page: {} and size: {}", page, size);
        List<UserResponseDto> users = userService.getAllUserByPagination(page, size);

        logger.info("Fetched {} users", users.size());
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Long userId){

        logger.info("Call user service for finding user");
        UserResponseDto userResponseDto = userService.findUserById(userId);

        logger.info("return response for for user");
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }


    @PutMapping("/update/{userId}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable Long userId,
                                                            @Valid @RequestBody UserUpdateRequestDto userUpdateRequestDto){

        logger.info("Call user service for update user");
        UserResponseDto userUpdateResponseDto = userService.updateUser(userId, userUpdateRequestDto);

        logger.info("return response of updated user with id");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userUpdateResponseDto);
    }

    @DeleteMapping("delete/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId){

        logger.info("Call user service for deleting user");
        String deletedUser = userService.deleteUserById(userId);

        logger.info("return response of updated user with Id ");
        return ResponseEntity.ok(deletedUser);

    }
}
