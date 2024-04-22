package com.bron.cinema.api.service;

import com.bron.cinema.model.MyUser;
import com.bron.cinema.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

@Service
@AllArgsConstructor
public class AppService {

    private UserRepository repository;
    private PasswordEncoder passwordEncoder;



    public void addUser(MyUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
    }
}
