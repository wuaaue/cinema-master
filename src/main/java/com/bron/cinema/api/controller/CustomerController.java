package com.bron.cinema.api.controller;

import com.bron.cinema.api.service.CustomerService;
import com.bron.cinema.model.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/api/customers/register")
    public ResponseEntity<String> register(@RequestBody CustomerDto customerDto) {
        System.out.println("Received registration request: " + customerDto);
        try {
            customerService.registerCustomer(customerDto);
            return ResponseEntity.ok("Registration successful");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Registration failed");
        }
    }
}

