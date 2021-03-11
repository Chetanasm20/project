package com.cachetech.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;

@SpringBootApplication
public class ShopItemsApplication {

	public static void main(String[] args) 
	{
		System.out.println();
		SpringApplication.run(ShopItemsApplication.class, args);
	}

}
