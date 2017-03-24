package com.udemy.converter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestCrypt {

	public static void main(String[] args) {

		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		System.out.println(pe.encode("user"));
		// $2a$10$WyXv27GxMIryHhkWGhnZ0u3xaMjFiA5jyQ40jQDPhnct24Ce6hVmC
	}

}
