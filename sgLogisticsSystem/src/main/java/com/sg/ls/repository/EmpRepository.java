package com.sg.ls.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.sg.ls.dto.EmpDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class EmpRepository {
	private final SqlSessionTemplate sql;
	
	public EmpDTO login(EmpDTO empDTO) {
		return sql.selectOne("Emp.login", empDTO);
	}
	
	public int save(EmpDTO empDTO) {
		return sql.insert("Emp.join", empDTO);
	}
	
	public boolean idCheck(EmpDTO empDTO) {
		return sql.selectOne("Emp.idCheck", empDTO);
	}
}
