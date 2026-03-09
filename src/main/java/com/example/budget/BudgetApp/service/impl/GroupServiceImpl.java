package com.example.budget.BudgetApp.service.impl;

import com.example.budget.BudgetApp.dto.GroupRequestDto;
import com.example.budget.BudgetApp.dto.GroupResponseDto;
import com.example.budget.BudgetApp.dto.GroupUpdateRequestDto;
import com.example.budget.BudgetApp.entity.Group;
import com.example.budget.BudgetApp.entity.User;
import com.example.budget.BudgetApp.exception.GroupNotFoundException;
import com.example.budget.BudgetApp.exception.UserNotFoundException;
import com.example.budget.BudgetApp.mapper.Impl.GroupRequestMapper;
import com.example.budget.BudgetApp.mapper.Impl.GroupResponseMapper;
import com.example.budget.BudgetApp.mapper.Impl.GroupUpdateRequestMapper;
import com.example.budget.BudgetApp.repository.GroupRepository;
import com.example.budget.BudgetApp.repository.UserRepository;
import com.example.budget.BudgetApp.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final GroupRequestMapper groupRequestMapper;
    private final GroupResponseMapper groupResponseMapper;
    private final GroupUpdateRequestMapper groupUpdateRequestMapper;
    private final UserRepository userRepository;

    @Override
    public GroupResponseDto updateGroupById(Long groupId, GroupUpdateRequestDto groupUpdateRequestDto) {
        Group group = groupRepository.findById(groupId).orElseThrow(() -> new GroupNotFoundException("Group not exist!!"));
        User user = userRepository.findById(group.getGroupAdmin().getUserId()).orElseThrow(() -> new UserNotFoundException("This admin is not exist!!"));

        group.setGroupName(groupUpdateRequestDto.getGroupName());
        group.setGroupDescription(groupUpdateRequestDto.getGroupDescription());

        Group updatedGroup = groupRepository.save(group);
        GroupResponseDto responseDto = groupResponseMapper.mapTo(updatedGroup);
        responseDto.setGroupAdminName(user.getUserName());
        return responseDto;
    }

    @Override
    public GroupResponseDto findGroupById(Long groupId) {
        Group group = groupRepository.findById(groupId).orElseThrow(() -> new GroupNotFoundException("Group not found "));
        User user = userRepository.findById(group.getGroupAdmin().getUserId()).orElseThrow(() -> new UserNotFoundException("This admin is not exist!!"));

        GroupResponseDto groupResponseDto = groupResponseMapper.mapTo(group);
        groupResponseDto.setGroupAdminName(user.getUserName());
        return groupResponseDto;
    }

    @Override
    public GroupResponseDto createGroup(GroupRequestDto groupRequestDto) {
        Group group = groupRequestMapper.mapFrom(groupRequestDto);
        Group newGroup = groupRepository.save(group);

        return groupResponseMapper.mapTo(newGroup);
    }
}
