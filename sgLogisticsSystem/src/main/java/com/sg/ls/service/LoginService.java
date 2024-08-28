package com.sg.ls.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sg.ls.dto.EmpDTO;
import com.sg.ls.repository.EmpRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {
	
	private final EmpRepository empRepository;
	
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	/*
	public boolean login(EmpDTO empDTO) {
		EmpDTO loginEmp = empRepository.login(empDTO);
		
		if(loginEmp != null) {
			return true;
		} else {
			return false;
		}
	}*/
	
	public boolean join(EmpDTO empDTO) {
		boolean idExists = empRepository.idCheck(empDTO);
		
		System.out.println("result: " + idExists);
		// 아이디 체크 통과(중복 아이디 없음)
		if(!idExists) {
			String cryptPw = bCryptPasswordEncoder.encode(empDTO.getEmpPw());	// 비밀번호 암호화
			
			empDTO.setEmpPw(cryptPw);
			empDTO.setEmpRole("ROLE_ADMIN");
			empDTO.setEmpNm("관리");
			empDTO.setDeptCd("1000");
			empDTO.setRankCd("1000");
			
			empRepository.save(empDTO);
			
			return true;
		} else {
			return false;
		}
	}
	
}
