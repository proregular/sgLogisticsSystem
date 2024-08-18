package com.sg.ls.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sg.ls.dto.EmpDTO;
import com.sg.ls.service.EmpService;
import com.sg.ls.service.SecurityService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class EmpController {

	private final EmpService empService;
	
	@GetMapping("/join")
	public String joinP() {
		return "join";
	}
	
	@PostMapping("/joinProc")
	public String joinProcess(EmpDTO empDTO) {
		
		empService.join(empDTO);
		
		return "redirect:/login";
	}
	
	
}
