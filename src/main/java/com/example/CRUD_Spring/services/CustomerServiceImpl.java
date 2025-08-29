package com.example.CRUD_Spring.services;

import com.example.CRUD_Spring.entities.Customer;
import com.example.CRUD_Spring.repositories.CustomerRepository;

public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer update(String code, Customer c){
        return customerRepository.findById(code).map(existingCustomer-> {
            existingCustomer.setName(c.getName());
            existingCustomer.setEmail(c.getEmail());
            existingCustomer.setAddress(c.getAddress());
            return customerRepository.save(existingCustomer);
        }).orElseThrow();
    }
}
