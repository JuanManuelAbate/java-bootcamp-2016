package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Main class to run using Spring Boot
 * 
 * @author Juan Manuel Abate
 */
@SpringBootApplication
@ComponentScan({ "controller", "com" })
public class ShoppingcartApplication {
	public static void main(String[] args) {
		SpringApplication.run(ShoppingcartApplication.class, args);
	}
}
