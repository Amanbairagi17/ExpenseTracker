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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final GroupRequestMapper groupRequestMapper;
    private final GroupResponseMapper groupResponseMapper;

    @Override
    public List<GroupResponseDto> getAllByPagination(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.ASC, "groupName");
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Group> groupPage = groupRepository.findAll(pageable);

        List<GroupResponseDto> groupResponseDtos = groupPage.stream()
                .map(groupResponseMapper::mapTo)
                .collect(Collectors.toList());

        return groupResponseDtos;
    }

    @Override
    public List<GroupResponseDto> getAllGroup() {
        List<Group> groupList = groupRepository.findAll();
        List<GroupResponseDto> list = new ArrayList<>();

        for (Group group : groupList){
            GroupResponseDto response = groupResponseMapper.mapTo(group);
            list.add(response);
//            User user = userRepository.findById(group.getGroupAdmin().getUserId()).orElseThrow(() -> new UserNotFoundException("Admin not found!!"));
//            response.setGroupAdminName(user.getUserName());
//            list.add(response);
        }

        return list;
    }

    @Override
    public String deleteGroupById(Long groupId) {
        Group group = groupRepository.findById(groupId).orElseThrow(() -> new GroupNotFoundException("Group Not Exist With ID " +groupId ));
        groupRepository.deleteById(groupId);
        return "Group deleted successfully with Id " +group.getGroupId();
    }

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

        User user = userRepository.findById(groupRequestDto.getGroupAdmin().getUserId()).orElseThrow(() -> new UserNotFoundException("Admin not Found!!"));

        GroupResponseDto response = groupResponseMapper.mapTo(newGroup);
        response.setGroupAdminName(user.getUserName());

        return response;
    }
}
