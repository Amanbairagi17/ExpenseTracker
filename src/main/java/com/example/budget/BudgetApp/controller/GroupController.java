package com.example.budget.BudgetApp.controller;


import com.example.budget.BudgetApp.dto.GroupRequestDto;
import com.example.budget.BudgetApp.dto.GroupResponseDto;
import com.example.budget.BudgetApp.dto.GroupUpdateRequestDto;
import com.example.budget.BudgetApp.helper.AppConstant;
import com.example.budget.BudgetApp.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "group")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @PostMapping
    public ResponseEntity<GroupResponseDto> createGroup(@RequestBody GroupRequestDto groupRequestDto){
        GroupResponseDto groupResponseDto = groupService.createGroup(groupRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(groupResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<GroupResponseDto>> getAllGroups(@RequestParam(value = "page", defaultValue = AppConstant.DEFAULT_PAGE) int page,
                                                               @RequestParam(value = "size", defaultValue = AppConstant.DEFAULT_SIZE) int size){
        List<GroupResponseDto> listOfGroups = groupService.getAllByPagination(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(listOfGroups);

    }

    @GetMapping("/all")
    public ResponseEntity<List<GroupResponseDto>> getAllGroup(){
        List<GroupResponseDto> listOfGroups = groupService.getAllGroup();
        return ResponseEntity.status(HttpStatus.OK).body(listOfGroups);
    }
    @GetMapping("/{groupId}")
    public ResponseEntity<GroupResponseDto> findByGroupWithId(@PathVariable Long groupId){
        GroupResponseDto groupResponseDto = groupService.findGroupById(groupId);
        return ResponseEntity.status(HttpStatus.OK).body(groupResponseDto);
    }

    @PutMapping("/{groupId}")
    public ResponseEntity<GroupResponseDto> updateGroupById(@PathVariable Long groupId,
                                                            @RequestBody GroupUpdateRequestDto groupUpdateRequestDto){

        GroupResponseDto groupResponseDto = groupService.updateGroupById(groupId, groupUpdateRequestDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(groupResponseDto);
    }

    @DeleteMapping("/{groupId}")
    public ResponseEntity<String> deleteGroup(@PathVariable Long groupId){
        String deletedGroup = groupService.deleteGroupById(groupId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(deletedGroup);
    }

}
