package com.example.demo;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

// @SpringBootApplication
public class DemoApplication {

	static Logger logger = LoggerFactory.getLogger(DemoApplication.class);

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("Let's inspect the beans provided by Spring Boot:");
			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String bean : beanNames) {
				System.out.println(bean);
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}

}
