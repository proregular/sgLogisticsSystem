package com.sg.ls.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sg.ls.dto.CustomUserDetails;
import com.sg.ls.dto.EmpDTO;
import com.sg.ls.repository.EmpRepository;

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
			return null;
		}
		
	}
}


