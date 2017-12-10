package com.demo.authserver.controller;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@RestController
public class HomeController {

	@Value("${some.test.property}")
	private String testProperty;
	
	@GetMapping("/user")
	public Principal user(Principal principal) {
		return principal;
	}
	@GetMapping("/test")
	public String test(@RequestParam String code, @RequestParam(required=false) Optional<String> state){
		
		return "Code:  " + code + ".  State:  " + state.orElse("not present.");
	}
}
