package com.example.demospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemospringApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemospringApplication.class, args);
		System.out.println(context.getBeanDefinitionCount());
	}

}
