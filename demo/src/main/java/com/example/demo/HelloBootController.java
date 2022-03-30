package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Spring Boot에서는 @Controller 대신 이걸 쓴다.
public class HelloBootController {
	
	@RequestMapping("/")
	public String hello() {
		
		return "처음보는 Spring Boot";
	}

}
