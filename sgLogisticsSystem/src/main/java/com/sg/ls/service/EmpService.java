package com.sg.ls.service;

import org.springframework.stereotype.Service;

import com.sg.ls.dto.EmpDTO;
import com.sg.ls.repository.EmpRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpService {
	
	private final EmpRepository empRepository;
	
	public boolean login(EmpDTO empDTO) {
		EmpDTO loginEmp = empRepository.login(empDTO);
		
		if(loginEmp != null) {
			return true;
		} else {
			return false;
		}
	}
	
}
