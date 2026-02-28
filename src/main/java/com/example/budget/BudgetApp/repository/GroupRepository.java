package com.example.budget.BudgetApp.repository;

import com.example.budget.BudgetApp.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Integer> {
}
