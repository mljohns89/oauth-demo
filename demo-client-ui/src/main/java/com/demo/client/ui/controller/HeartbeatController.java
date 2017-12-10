package com.demo.client.ui.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeartbeatController {
	
	@GetMapping("/heartbeat")
	public String heartbeat() {
		return "heartbeat";
	}

	@GetMapping("/test")
	public String test(@RequestParam String code, @RequestParam(required=false) Optional<String> state){
		
		return "Code:  " + code + ".  State:  " + state.orElse("not present.");
	}
}
