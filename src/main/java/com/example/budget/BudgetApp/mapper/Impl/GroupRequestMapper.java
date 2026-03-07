package com.example.budget.BudgetApp.mapper.Impl;

import com.example.budget.BudgetApp.dto.GroupRequestDto;
import com.example.budget.BudgetApp.entity.Group;
import com.example.budget.BudgetApp.mapper.Mapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class GroupRequestMapper implements Mapper<Group, GroupRequestDto> {

    private final ModelMapper modelMapper;

    @Override
    public GroupRequestDto mapTo(Group group) {
        return modelMapper.map(group, GroupRequestDto.class);
    }

    @Override
    public Group mapFrom(GroupRequestDto groupRequestDto) {
        return modelMapper.map(groupRequestDto, Group.class);
    }
}
