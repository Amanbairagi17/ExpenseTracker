package com.example.budget.BudgetApp.service.impl;

import com.example.budget.BudgetApp.dto.GroupRequestDto;
import com.example.budget.BudgetApp.dto.GroupResponseDto;
import com.example.budget.BudgetApp.entity.Group;
import com.example.budget.BudgetApp.exception.GroupNotFoundException;
import com.example.budget.BudgetApp.mapper.Impl.GroupRequestMapper;
import com.example.budget.BudgetApp.mapper.Impl.GroupResponseMapper;
import com.example.budget.BudgetApp.repository.GroupRepository;
import com.example.budget.BudgetApp.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final GroupRequestMapper groupRequestMapper;
    private final GroupResponseMapper groupResponseMapper;

    @Override
    public GroupResponseDto findGroupById(Long groupId) {
        Group group = groupRepository.findById(groupId).orElseThrow(() -> new GroupNotFoundException("Group not found "));
        GroupResponseDto groupResponseDto = groupResponseMapper.mapTo(group);
        return groupResponseDto;
    }

    @Override
    public GroupResponseDto createGroup(GroupRequestDto groupRequestDto) {
        Group group = groupRequestMapper.mapFrom(groupRequestDto);
        Group newGroup = groupRepository.save(group);

        return groupResponseMapper.mapTo(newGroup);
    }
}
