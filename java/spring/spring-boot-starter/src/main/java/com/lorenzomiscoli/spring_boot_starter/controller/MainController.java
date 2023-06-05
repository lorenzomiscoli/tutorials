package com.lorenzomiscoli.spring_boot_starter.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	private String appName;

	public MainController(@Value("${spring.application.name}") final String appName) {
		this.appName = appName;
	}

	@GetMapping("/")
	public String homePage(Model model) {
		model.addAttribute("appName", appName);
		return "home";
	}
	
}
