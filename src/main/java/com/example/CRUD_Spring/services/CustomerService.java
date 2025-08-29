package com.example.CRUD_Spring.services;

import com.example.CRUD_Spring.entities.Customer;

public interface CustomerService {
    Customer update(String code, Customer c);
}
