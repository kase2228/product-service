package com.ctbe.kassahun;

import com.ctbe.kassahun.model.Product;
import com.ctbe.kassahun.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner seedData(ProductRepository repo) {
		return args -> {
			repo.save(new Product("Laptop",  1200.00));
			repo.save(new Product("Monitor",  350.00));
			repo.save(new Product("Keyboard",  85.00));
		};
	}
}

