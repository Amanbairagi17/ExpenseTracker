package com.example.budget.BudgetApp.repository;

import com.example.budget.BudgetApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
