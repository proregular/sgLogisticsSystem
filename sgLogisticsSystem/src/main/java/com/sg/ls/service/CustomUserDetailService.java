package com.sg.ls.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sg.ls.dto.CustomUserDetails;
import com.sg.ls.dto.EmpDTO;
import com.sg.ls.repository.EmpRepository;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
	
	private final EmpRepository empRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		EmpDTO empData = empRepository.login(username);
		
		if(empData != null) {
			System.out.println("성공");
			
			return new CustomUserDetails(empData);
		} else {
			throw new UsernameNotFoundException("사용자가 존재하지 않습니다.");
		} 
		
	}
}


