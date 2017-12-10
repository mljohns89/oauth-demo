package com.demo.client.ui.controller;

import java.util.Optional;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@RestController
public class AuthController {

	
	@GetMapping("/auth/confirmAccess")
	public String confirmAccess(@RequestParam String code, @RequestParam String state) {
		
		return code + ":" + state;
		
	}
	
	@GetMapping("/hello")
	public String helloUser(){
		OAuth2AuthenticationDetails authenticationDetails = 
				(OAuth2AuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
		String accessToken = authenticationDetails.getTokenValue();
		return accessToken;
		//or do some call to some ResourceServer with the access token.
	}
	
	@GetMapping("/getAuthCode")
	public String getAuthCode() throws UnirestException {
		HttpResponse<String> response = 
				Unirest.post(
						"http://localhost:8080/oauth/authorize"
						+ "?response_type=code"
						+ "&client_id=trusted-app"
						+ "&redirect_uri=http://localhost:8080/test"
						)
				  .asString();
		
		return "code";
	}
}
