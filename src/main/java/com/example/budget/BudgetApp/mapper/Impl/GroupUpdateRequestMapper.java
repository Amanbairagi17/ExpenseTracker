package com.example.budget.BudgetApp.mapper.Impl;

import com.example.budget.BudgetApp.dto.GroupUpdateRequestDto;
import com.example.budget.BudgetApp.entity.Group;
import com.example.budget.BudgetApp.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GroupUpdateRequestMapper implements Mapper<Group, GroupUpdateRequestDto> {

    private final ModelMapper modelMapper;

    @Override
    public GroupUpdateRequestDto mapTo(Group group) {
        return modelMapper.map(group, GroupUpdateRequestDto.class);
    }

    @Override
    public Group mapFrom(GroupUpdateRequestDto groupUpdateRequestDto) {
        return modelMapper.map(groupUpdateRequestDto, Group.class);
    }
}
