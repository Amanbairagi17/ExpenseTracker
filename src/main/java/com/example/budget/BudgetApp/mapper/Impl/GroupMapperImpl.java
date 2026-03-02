package com.example.budget.BudgetApp.mapper.Impl;

import com.example.budget.BudgetApp.dto.GroupRequestDto;
import com.example.budget.BudgetApp.dto.GroupResponseDto;
import com.example.budget.BudgetApp.entity.Group;
import com.example.budget.BudgetApp.mapper.GroupMapper;

public class GroupMapperImpl implements GroupMapper {
    @Override
    public Group toGroupDto(GroupRequestDto groupRequestDto) {
        Group group = new Group();
        group.setGroupName(groupRequestDto.getGroupName());
        group.setGroupAdmin(groupRequestDto.getGroupAdmin());
        group.setMembers(groupRequestDto.getMembers());
        group.setGroupDescription(group.getGroupDescription());
        return group;
    }

    @Override
    public GroupResponseDto fromGroupDto(Group group) {
        GroupResponseDto groupResponseDto = new GroupResponseDto();
        groupResponseDto.setGroupId(group.getGroupId());
        groupResponseDto.setGroupAdmin(group.getGroupAdmin());
        groupResponseDto.setGroupName(group.getGroupName());
        groupResponseDto.setMembers(group.getMembers());
        groupResponseDto.setGroupDescription(group.getGroupDescription());
        return groupResponseDto;
    }
}
