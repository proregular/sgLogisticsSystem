package com.sg.ls.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MainController {
	
	@GetMapping("/dashboard")
	public String dashboardP(Model model, HttpServletRequest request) {
		model.addAttribute("servletPath", request.getServletPath());
		
		return "dashboard";
	}
}
