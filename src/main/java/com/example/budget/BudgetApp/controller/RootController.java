package com.example.budget.BudgetApp.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "home")

public class RootController {
    @GetMapping("/api/v1/")
    public String home(){
        return "home page";
    }

    @GetMapping("/health")
    public String health(){
        return "Application is running!";
    }
}
