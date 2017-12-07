package com.demo.authserver.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public String test() throws UnirestException {
		
		HttpResponse<JsonNode> jsonResponse = Unirest.post("http://httpbin.org/post")
				  .header("accept", "application/json")
				  .queryString("apiKey", "123")
				  .field("parameter", "value")
				  .field("foo", "bar")
				  .asJson();
		
		return testProperty;
	}
}
