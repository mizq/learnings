package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/example4")
public class Example4Controller {

	
	private static final String ERROR = "404";
	private static final String EXCEPTION = "500";
	
	@GetMapping("/error")
	public String errorView() {
		return ERROR;
	}
	
	@GetMapping("/exception")
	public String exceptionView() {
		return EXCEPTION;
	}
}
