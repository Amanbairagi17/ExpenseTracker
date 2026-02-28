package com.example.budget.BudgetApp.repository;

import com.example.budget.BudgetApp.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
