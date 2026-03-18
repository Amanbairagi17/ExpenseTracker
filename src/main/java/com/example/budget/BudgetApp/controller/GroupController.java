package com.example.budget.BudgetApp.controller;


import com.example.budget.BudgetApp.dto.GroupRequestDto;
import com.example.budget.BudgetApp.dto.GroupResponseDto;
import com.example.budget.BudgetApp.dto.GroupUpdateRequestDto;
import com.example.budget.BudgetApp.helper.AppConstant;
import com.example.budget.BudgetApp.service.GroupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "group")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    private static final Logger logger = LoggerFactory.getLogger(GroupController.class);

    @PostMapping
    public ResponseEntity<GroupResponseDto> createGroup(@Valid @RequestBody GroupRequestDto groupRequestDto){

        logger.info("START -> Create Group API called");
        logger.debug("Request Payload: {}", groupRequestDto);

        GroupResponseDto groupResponseDto = groupService.createGroup(groupRequestDto);

        logger.info("END -> Group created successfully with ID: {}", groupResponseDto.getGroupId());

        return ResponseEntity.status(HttpStatus.CREATED).body(groupResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<GroupResponseDto>> getAllGroups(
            @RequestParam(value = "page", defaultValue = AppConstant.DEFAULT_PAGE) int page,
            @RequestParam(value = "size", defaultValue = AppConstant.DEFAULT_SIZE) int size){

        logger.info("START -> Fetch paginated groups | page: {}, size: {}", page, size);

        List<GroupResponseDto> listOfGroups = groupService.getAllByPagination(page, size);

        logger.info("END -> Fetched {} groups (paginated)", listOfGroups.size());

        return ResponseEntity.status(HttpStatus.OK).body(listOfGroups);
    }

    @GetMapping("/all")
    public ResponseEntity<List<GroupResponseDto>> getAllGroup(){

        logger.info("START -> Fetch all groups");

        List<GroupResponseDto> listOfGroups = groupService.getAllGroup();

        logger.info("END -> Fetched total {} groups", listOfGroups.size());

        return ResponseEntity.status(HttpStatus.OK).body(listOfGroups);
    }

    @GetMapping("/{groupId}")
    public ResponseEntity<GroupResponseDto> findByGroupWithId(@PathVariable Long groupId){

        logger.info("START -> Fetch group by ID: {}", groupId);

        GroupResponseDto groupResponseDto = groupService.findGroupById(groupId);

        logger.info("END -> Group fetched successfully for ID: {}", groupId);

        return ResponseEntity.status(HttpStatus.OK).body(groupResponseDto);
    }

    @PutMapping("/{groupId}")
    public ResponseEntity<GroupResponseDto> updateGroupById(
            @PathVariable Long groupId,
            @Valid @RequestBody GroupUpdateRequestDto groupUpdateRequestDto){

        logger.info("START -> Update group with ID: {}", groupId);
        logger.debug("Update Payload: {}", groupUpdateRequestDto);

        GroupResponseDto groupResponseDto = groupService.updateGroupById(groupId, groupUpdateRequestDto);

        logger.info("END -> Group updated successfully with ID: {}", groupId);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(groupResponseDto);
    }

    @DeleteMapping("/{groupId}")
    public ResponseEntity<String> deleteGroup(@PathVariable Long groupId){

        logger.info("START -> Delete group with ID: {}", groupId);

        String deletedGroup = groupService.deleteGroupById(groupId);

        logger.info("END -> Group deleted successfully with ID: {}", groupId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(deletedGroup);
    }
}