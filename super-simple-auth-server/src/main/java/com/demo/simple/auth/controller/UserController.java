package com.demo.simple.auth.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@GetMapping("/heartbeat")
	public String heartbeat() {
		return "heartbeat";
	}
	
	@GetMapping("/user")
	public Principal user(Principal principal) {
		return principal;
	}

}
