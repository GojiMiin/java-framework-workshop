package com.example.demospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class DemospringApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context
				= SpringApplication.run(DemospringApplication.class, args);
		// Beans
		String[] names = context.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
		Arrays.stream(names).forEach(System.out::println);

		System.out.println(context.getBeanDefinitionCount());
	}

}
