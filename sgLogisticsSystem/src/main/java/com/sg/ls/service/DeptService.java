package com.sg.ls.service;

import java.util.List;

import com.sg.ls.dto.DeptDTO;
import com.sg.ls.dto.ResponseDTO;

public interface DeptService {
	ResponseDTO<String> addDept(DeptDTO deptDTO);
	
	List<DeptDTO> findDeptByNameAndCode(String name, String code);
	
	ResponseDTO<String> modifyDept(DeptDTO deptDTO);
	
	ResponseDTO<String> removeDept(List<String> ids);
}
