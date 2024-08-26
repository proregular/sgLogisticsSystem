package com.sg.ls.dto;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {
	
	private EmpDTO empDTO;
	
	public CustomUserDetails(EmpDTO empDTO) {
		this.empDTO = empDTO;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Collection<GrantedAuthority> collection = new ArrayList<>();
		
		collection.add(new GrantedAuthority() {
			
			@Override
			public String getAuthority() {

				return empDTO.getEmpRole();
			}
		});
		
		return collection;
	}

	@Override
	public String getPassword() {

		return empDTO.getEmpPw();
	}

	@Override
	public String getUsername() {

		return empDTO.getEmpId();
	}
	
	public String getEmpNm() {
		
		return empDTO.getEmpNm();
	}
	
	public String getRankCd() {
		return empDTO.getRankCd();
	}
	
	public String getRankNm() {
		return empDTO.getRankNm();
	}
	
	public String getDeptCd() {
		return empDTO.getDeptCd();
	}
	
	public String getDeptNm() {
		return empDTO.getDeptNm();
	}
}
