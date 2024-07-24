package com.sg.ls.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String mainP() {
		
		return "main";
	}
	
	@GetMapping("/dashboard")
	public String dashboardP(Model model) {
		
		return "dashboard";
	}
}
