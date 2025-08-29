package com.example.CRUD_Spring.web;

import com.example.CRUD_Spring.entities.Customer;
import com.example.CRUD_Spring.repositories.CustomerRepository;
import com.example.CRUD_Spring.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CustomerController {
    private final CustomerRepository repo;
    private CustomerService service;
    public CustomerController(CustomerRepository repo) {
        this.repo = repo;
    }
    @GetMapping(path = "/customer")
    public List<Customer> getAllCustomers() {
        return repo.findAll();
    }
    @GetMapping(path = "/customer/{id}")
    public Customer getCustomer(@PathVariable(name = "id") String code){
        return repo.findById(code).get();
    }
    @PostMapping(path = "/customer")
    public Customer create(@RequestBody Customer c){
        return repo.save(c);
    }
    @PutMapping(path = "/customer/{code}")
    public Customer update(@PathVariable String code, @RequestBody Customer c){
        return service.update(code, c);
    }
    @DeleteMapping(path = "/customer/{code}")
    public void delete(@PathVariable String code){
        repo.deleteById(code);
    }
}
