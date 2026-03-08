package com.example.budget.BudgetApp.service;

import com.example.budget.BudgetApp.dto.GroupRequestDto;
import com.example.budget.BudgetApp.dto.GroupResponseDto;

public interface GroupService {
    GroupResponseDto createGroup(GroupRequestDto groupRequestDto);

    GroupResponseDto findGroupById(Long groupId);
}
