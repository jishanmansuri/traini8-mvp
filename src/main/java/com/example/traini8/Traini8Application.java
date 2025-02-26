package com.example.traini8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.traini8.repository")
public class Traini8Application {

	public static void main(String[] args) {
		SpringApplication.run(Traini8Application.class, args);
	}

}
