package com.lorenzomiscoli.docker_java;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/docker-java")
	public String getMessage() {
		return "Running";
	}

}
