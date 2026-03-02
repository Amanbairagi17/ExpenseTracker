package com.example.budget.BudgetApp.dto;

import com.example.budget.BudgetApp.entity.User;

import java.util.List;

public class GroupRequestDto {
    private String groupName;
    private int groupAdmin;
    private List<User> members;
    private String groupDescription;
}
