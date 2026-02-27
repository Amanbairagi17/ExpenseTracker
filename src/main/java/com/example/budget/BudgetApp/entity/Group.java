package com.example.budget.BudgetApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Entity
@Data
@AllArgsConstructor

public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int groupId;

    @Column(nullable = false)
    private String groupName;

    @OneToMany(fetch = FetchType.EAGER)
    private List<User> members;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_admin", nullable = false)
    private User admin;

    private String groupDescription;
}
