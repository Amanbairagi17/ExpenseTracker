package com.example.budget.BudgetApp.dto;


import com.example.budget.BudgetApp.entity.User;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class GroupUpdateRequestDto {
    @NotEmpty(message = "Group name required") @Size(min = 4, max = 20, message = "Group name between 4 to 20 character")
    private String groupName;

    @NotEmpty
    private String groupDescription;
}
