package com.udemy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BackendninjaProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendninjaProjectApplication.class, args);
	}
}
