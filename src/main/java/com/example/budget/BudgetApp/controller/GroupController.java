package com.example.budget.BudgetApp.controller;


import com.example.budget.BudgetApp.dto.GroupRequestDto;
import com.example.budget.BudgetApp.dto.GroupResponseDto;
import com.example.budget.BudgetApp.dto.GroupUpdateRequestDto;
import com.example.budget.BudgetApp.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
