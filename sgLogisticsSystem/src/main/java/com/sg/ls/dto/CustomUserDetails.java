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
	

}
