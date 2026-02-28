package com.example.budget.BudgetApp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class Payment {
    @Id
    @Column(nullable = false)
    private int transactionId;

    @ManyToOne
    private User user;

    @ManyToOne
    private  Group group;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private LocalDateTime paymentDateTime;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private String paymentDescription;
}
