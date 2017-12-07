package com.demo.authserver.controller;

import java.security.Principal;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

	@GetMapping("/api/test")
	public String apitest(){
		return new String("Hello apiTest!");
	}

	@GetMapping(value = "/api/hello", produces = "application/json")
	public String helloUser(){
		// The authenticated user can be fetched using the SecurityContextHolder
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		return new String(String.format("Hello '%s'!", username));
	}

	@GetMapping("/api/admin")
	// If a controller request asks for the Principal user in
	// the method declaration Spring security will provide it.
	public String helloAdmin(Principal principal){
		return new String(String.format("Welcome '%s'!", principal.getName()));
	}
}
