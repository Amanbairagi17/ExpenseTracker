package com.example.budget.BudgetApp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

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

    private String paymentDescription;
}
