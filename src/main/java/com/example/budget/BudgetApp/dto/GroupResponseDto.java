package com.example.budget.BudgetApp.dto;

import com.example.budget.BudgetApp.entity.User;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
public class GroupResponseDto {
    private Long groupId;
    private String groupName;
    private String groupAdminName;
    private String groupDescription;
}
