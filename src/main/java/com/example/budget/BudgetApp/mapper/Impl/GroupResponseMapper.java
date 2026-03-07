package com.example.budget.BudgetApp.mapper.Impl;

import com.example.budget.BudgetApp.dto.GroupResponseDto;
import com.example.budget.BudgetApp.entity.Group;
import com.example.budget.BudgetApp.mapper.Mapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GroupResponseMapper implements Mapper<Group, GroupResponseDto> {

    private final ModelMapper modelMapper;

    @Override
    public GroupResponseDto mapTo(Group group) {
        return modelMapper.map(group, GroupResponseDto.class);
    }

    @Override
    public Group mapFrom(GroupResponseDto groupResponseDto) {
        return modelMapper.map(groupResponseDto, Group.class);
    }
}
