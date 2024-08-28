package com.sg.ls.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sg.ls.dto.EmpDTO;
import com.sg.ls.service.LoginService;
import com.sg.ls.service.SecurityService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {

	private final LoginService loginService;
	
	@GetMapping("/join")
	public String joinP() {
		return "join";
	}
	
	@PostMapping("/joinProc")
	public String joinProcess(EmpDTO empDTO) {
		
		loginService.join(empDTO);
		
		return "redirect:/login";
	}
	
	
}
