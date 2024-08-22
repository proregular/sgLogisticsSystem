package com.sg.ls.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sg.ls.service.EmpService;
import com.sg.ls.service.SecurityService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {
	private final SecurityService securityService;
	
	@GetMapping(value = {"/", "/login"})
	public String loginP() {
		if(securityService.isAuthenticated()) {
			return "redirect:/dashboard";
		} else {
			return "login";
		}
	}
	
	@GetMapping("/dashboard")
	public String dashboardP(Model model, HttpServletRequest request) {
		model.addAttribute("servletPath", request.getServletPath());
		
		return "dashboard";
	}
	
	@GetMapping("/trade_mng")
	public String tradeMngP(Model model, HttpServletRequest request) {
		model.addAttribute("servletPath", request.getServletPath());
		
		return "sysm/trade_mng";
	}
	
	@GetMapping("/dept_mng")
	public String deptMngP(Model model, HttpServletRequest request) {
		model.addAttribute("servletPath", request.getServletPath());
		
		return "sysm/dept_mng";
	}
	
	@GetMapping("/rank_mng")
	public String rankMngP(Model model, HttpServletRequest request) {
		model.addAttribute("servletPath", request.getServletPath());
		
		return "sysm/rank_mng";
	}
}
