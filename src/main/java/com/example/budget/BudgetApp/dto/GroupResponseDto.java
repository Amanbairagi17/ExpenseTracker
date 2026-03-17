package com.example.budget.BudgetApp.dto;

import com.example.budget.BudgetApp.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
public class GroupResponseDto {
    @NotBlank
    private Long groupId;

    @NotEmpty(message = "Group name is required") @Size(min = 4, max = 20)
    private String groupName;

    @NotEmpty(message = "Group must have a admin")
    private String groupAdminName;

    @NotEmpty
    private String groupDescription;
}
