package com.example.budget.BudgetApp.mapper;

import com.example.budget.BudgetApp.dto.GroupRequestDto;
import com.example.budget.BudgetApp.dto.GroupResponseDto;
import com.example.budget.BudgetApp.entity.Group;
import org.springframework.stereotype.Component;

@Component
public interface GroupMapper {
    public Group toGroupDto(GroupRequestDto groupRequestDto);
    public GroupResponseDto fromGroupDto(Group group);
}
