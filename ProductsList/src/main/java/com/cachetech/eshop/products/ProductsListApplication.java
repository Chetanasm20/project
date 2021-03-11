package com.cachetech.eshop.products;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
public class ProductsListApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsListApplication.class, args);
	}

	

}
