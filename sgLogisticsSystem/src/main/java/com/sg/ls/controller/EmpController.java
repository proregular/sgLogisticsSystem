package com.sg.ls.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sg.ls.dto.EmpDTO;
import com.sg.ls.service.EmpService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class EmpController {

	private final EmpService empService;
	
	@GetMapping("/login")
	public String loginP() {
		
		return "login";
	}
	
	@PostMapping("/loginProc")
	public String loginProcess(@ModelAttribute EmpDTO empDTO, HttpSession session) {
		boolean loginResult = empService.login();
		
		if(loginResult) {
			session.setAttribute("loginId", empDTO.getEmpId());
			return "dashboard";
		} else {
			return "login";
		}
	}
}
