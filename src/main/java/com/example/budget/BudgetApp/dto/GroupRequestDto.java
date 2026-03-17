package com.example.budget.BudgetApp.dto;

import com.example.budget.BudgetApp.entity.User;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class GroupRequestDto {
    @NotEmpty(message = "Name cannot be null")  @Size(min = 4, max = 20)
    private String groupName;

    @NotEmpty(message = "Group must have a group admin")
    private User groupAdmin;

    @NotEmpty
    private String groupDescription;
}
