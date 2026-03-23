package com.example.budget.BudgetApp.service;

import com.example.budget.BudgetApp.dto.GroupRequestDto;
import com.example.budget.BudgetApp.dto.GroupResponseDto;
import com.example.budget.BudgetApp.dto.GroupUpdateRequestDto;

import java.util.List;

public interface GroupService {
    GroupResponseDto createGroup(GroupRequestDto groupRequestDto);

    GroupResponseDto findGroupById(Long groupId);

    GroupResponseDto updateGroupById(Long groupId, GroupUpdateRequestDto groupUpdateRequestDto);

    String deleteGroupById(Long groupId);

    List<GroupResponseDto> getAllGroup();

    List<GroupResponseDto> getAllByPagination(int page, int size);
}