package com.example.budget.BudgetApp.security;

import com.example.budget.BudgetApp.entity.User;
import com.example.budget.BudgetApp.repository.UserRepository;
import com.example.budget.BudgetApp.service.JWTService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class OAuth2SuccessHandler implements AuthenticationSuccessHandler {
    private final UserRepository userRepository;
    private final JWTService jwtService;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        OAuth2AuthenticationToken auth2AuthenticationToken = (OAuth2AuthenticationToken) authentication;
        OAuth2User OAuth2User =  auth2AuthenticationToken.getPrincipal();

        String email = OAuth2User.getAttribute("email");
        String name = OAuth2User.getAttribute("name");

        log.info(email + " " + name);

        if(!userRepository.existsByEmail(email)) {
            User user = new User();
            user.setEmail(email);
            user.setName(name);

            //dummy password
            user.setPassword(passwordEncoder.encode("oauth_password"));
            userRepository.save(user);
        }

        String token = jwtService.generateToken(email);

        String jsonResponse = String.format(
                "{\"token\": \"%s\", \"email\": \"%s\"}", token, email
        );
        response.getWriter().write(jsonResponse);
        response.getWriter().flush();
    }
}
