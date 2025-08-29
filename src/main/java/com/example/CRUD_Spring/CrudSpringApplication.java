package com.example.CRUD_Spring;

import com.example.CRUD_Spring.entities.Customer;
import com.example.CRUD_Spring.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}
	@Bean
	CommandLineRunner start(CustomerRepository customerRepository){
		return args -> {
			customerRepository.save(Customer.builder()
							.name("Fatou").code("1121").email("fatou@gmail.com").address("helenenstrasse")
					        .build());
			customerRepository.save(Customer.builder()
							.name("klaus").code("1122").email("klaus@gmail.com").address("steinstrasse")
							.build());
			customerRepository.save(Customer.builder()
							.name("Tifanie").code("1123").email("tifanie@gmail.com").address("gerichtstrasse")
							.build());
			customerRepository.save(Customer.builder()
							.name("John").code("1124").email("john@gmail.com").address("rechtstrasse")
							.build());
			customerRepository.findAll().forEach(custumer -> {
				System.out.println(custumer.getName());
				System.out.println(custumer.getEmail());
				System.out.println(custumer.getAddress());
			});
		};
	}

}
