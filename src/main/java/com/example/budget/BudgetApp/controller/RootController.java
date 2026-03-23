package com.example.budget.BudgetApp.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(path = "/home")

public class RootController {

    private static final Logger logger = LoggerFactory.getLogger(RootController.class);

    @GetMapping("/api/v1/")
    public String home(){
        logger.info("START -> Home API called");

        String response = "home page";

        logger.info("END -> Home API response sent");

        return response;
    }

    @GetMapping("/health")
    public String health(){
        logger.info("START -> Health Check API called");

        String response = "Application is running!";

        logger.info("END -> Health Check successful");

        return response;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
