package com.example.coffeemachine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CoffeeMachineApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CoffeeMachineApplication.class, args);
		CafeService cafeService = context.getBean(CafeService.class);
		cafeService.startCoffee();
	}

}
