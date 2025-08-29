package com.example.CRUD_Spring.repositories;

import com.example.CRUD_Spring.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
