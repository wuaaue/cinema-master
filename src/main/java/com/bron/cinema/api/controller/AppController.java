package com.bron.cinema.api.controller;

import com.bron.cinema.api.service.AppService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.bron.cinema.model.MyUser;


@RestController
@RequestMapping("api/apps")
@AllArgsConstructor
public class AppController {

    private AppService service;


    @PostMapping("/new-user")
    public String addUser(@RequestBody MyUser user) {
        service.addUser(user);
        return "User is saved";
    }
}
