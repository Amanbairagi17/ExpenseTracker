package com.example.budget.BudgetApp.dto;


import com.example.budget.BudgetApp.entity.User;
import lombok.Data;

@Data
public class GroupUpdateRequestDto {
    private String groupName;
    private String groupDescription;
}
