package com.example.budget.BudgetApp.dto;

import com.example.budget.BudgetApp.entity.User;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class GroupRequestDto {
    private String groupName;
    private User groupAdmin;
    private List<User> members;
    private String groupDescription;
}
