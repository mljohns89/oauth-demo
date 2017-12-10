package com.demo.resource.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceApiController {

	@GetMapping("/api/test")
	public String apiTest() {
		return "Hello Test!";
	}
}
