package com.bron.cinema.api.service;

import com.bron.cinema.model.Customer;
import com.bron.cinema.model.CustomerDto;
import com.bron.cinema.repository.CustomerRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public CustomerService(CustomerRepository customerRepository, BCryptPasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setName(customerDto.getFirstName() + " " + customerDto.getLastName());
        customer.setEmail(customerDto.getEmail());
        customer.setPhone(customerDto.getPhone());
        customer.setRoles("ROLE_USER");

        // Хеширование пароля
        String hashedPassword = passwordEncoder.encode(customerDto.getPassword());
        customer.setPassword(hashedPassword);

        customerRepository.save(customer);
    }
}
