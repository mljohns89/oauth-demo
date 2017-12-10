package com.demo.client.ui.controller;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

	
	@GetMapping("/userInfo")
	public String userInfo(){
		OAuth2AuthenticationDetails authenticationDetails = 
				(OAuth2AuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
		String accessToken = authenticationDetails.getTokenValue();		
		
		return "Our Access Token:  " + accessToken;
		//or do some call to some ResourceServer with the access token.
	}
}
