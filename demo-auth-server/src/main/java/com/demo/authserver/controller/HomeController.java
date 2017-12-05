package com.demo.authserver.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@Value("${some.test.property}")
	private String testProperty;
	
	@GetMapping("/user")
	public Principal user(Principal principal) {
		return principal;
	}
	@GetMapping("/test")
	public String test() {
		return testProperty;
	}
}
