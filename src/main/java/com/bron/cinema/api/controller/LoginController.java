package com.bron.cinema.api.controller;

import com.bron.cinema.model.MyUser;
import com.bron.cinema.model.UserCredentials;
import com.bron.cinema.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/api/login")
    public String login(@RequestBody UserCredentials credentials) {
        MyUser user = userRepository.findByEmail(credentials.getEmail())
                .orElse(null);

        System.out.printf("User: %s\n", user);
        System.out.printf("User password from DB: %s\n", user != null ? user.getPassword() : "null");
        System.out.printf("Password from credentials: %s\n", credentials.getPassword());

        if (user != null && passwordEncoder.matches(credentials.getPassword(), user.getPassword())) {
            return "Success";
        } else {
            return "Failure";
        }
    }
}
