package com.example.budget.BudgetApp.mapper.Impl;

import com.example.budget.BudgetApp.dto.GroupRequestDto;
import com.example.budget.BudgetApp.dto.GroupResponseDto;
import com.example.budget.BudgetApp.entity.Group;
import com.example.budget.BudgetApp.entity.User;
import com.example.budget.BudgetApp.mapper.GroupMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class GroupMapperImpl implements GroupMapper {
    @Override
    public Group toGroupDto(GroupRequestDto groupRequestDto) {
        Group group = new Group();

        group.setGroupName(groupRequestDto.getGroupName());
        group.setGroupDescription(group.getGroupDescription());

        return group;
    }

    @Override
    public GroupResponseDto fromGroupDto(Group group) {
        GroupResponseDto groupResponseDto = new GroupResponseDto();

        groupResponseDto.setGroupId(group.getGroupId());
        groupResponseDto.setGroupAdmin(group.getGroupAdmin());
        groupResponseDto.setGroupName(group.getGroupName());
        groupResponseDto.setGroupDescription(group.getGroupDescription());

        List<String> members = group.getMembers()
                .stream()
                .map(User::getUserName)
                .collect(Collectors.toList());

        groupResponseDto.setMembers(members);
        return groupResponseDto;
    }
}
