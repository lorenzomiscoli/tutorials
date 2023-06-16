package com.lorenzomiscoli.spring_security_basic_auth.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

	@GetMapping("/messages")
	public Map<String, String> getMessage() {
		return Map.of("message", "Ok");
	}

}
