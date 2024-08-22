package com.sg.ls.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sg.ls.dto.ResponseDTO;
import com.sg.ls.dto.DeptDTO;
import com.sg.ls.service.DeptServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/dept")
public class DeptController {
	
	@Autowired
	private DeptServiceImpl deptServiceImpl;
	
	@GetMapping
	public List<DeptDTO> getAllDept(@RequestParam(required = false, value="srch_dept_nm") String name, @RequestParam(required = false, value="srch_dept_cd") String code) {
		return deptServiceImpl.findDeptByNameAndCode(name, code);
	}
	
	@PostMapping
	public ResponseDTO<String> addDept(@Valid @RequestBody DeptDTO deptDTO) {
		return deptServiceImpl.addDept(deptDTO);
	}
	
	@PutMapping("/{id}")
	public ResponseDTO<String> modifyDept(@PathVariable("id") String id, @Valid @RequestBody DeptDTO deptDTO) {
		deptDTO.setDeptCd(id);
		return deptServiceImpl.modifyDept(deptDTO);
	}
	
	@PostMapping("/delete")
	public ResponseDTO<String> removeDept(@RequestParam(value="ids[]") List<String> ids) {
		return deptServiceImpl.removeDept(ids);
	}
	
}
