package com.example.budget.BudgetApp.dto;

import com.example.budget.BudgetApp.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class GroupRequestDto {
    private String groupName;
    private User groupAdmin;
    private String groupDescription;
}
