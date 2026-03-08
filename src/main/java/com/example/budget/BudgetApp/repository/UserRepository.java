package com.example.budget.BudgetApp.repository;

import com.example.budget.BudgetApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    void deleteById(Long userId);
}
