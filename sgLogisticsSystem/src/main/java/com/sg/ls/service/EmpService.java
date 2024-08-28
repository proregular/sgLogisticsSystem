package com.sg.ls.service;

import java.util.List;

import com.sg.ls.dto.ResponseDTO;
import com.sg.ls.dto.EmpDTO;

public interface EmpService {
ResponseDTO<String> addEmp(EmpDTO empDTO);
	
	List<EmpDTO> findEmpByNameAndCode(String name, String code);
	
	ResponseDTO<String> modifyEmp(EmpDTO empDTO);
	
	ResponseDTO<String> removeEmp(List<String> ids);
}
