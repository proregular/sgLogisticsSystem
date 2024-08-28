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

import com.sg.ls.dto.EmpDTO;
import com.sg.ls.dto.ResponseDTO;
import com.sg.ls.service.EmpServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/emp")
public class EmpController {
	@Autowired
	private EmpServiceImpl empServiceImpl;
	
	@GetMapping
	public List<EmpDTO> getAllEmp(@RequestParam(required = false, value="srch_emp_nm") String name, @RequestParam(required = false, value="srch_emp_id") String code) {
		return empServiceImpl.findEmpByNameAndCode(name, code);
	}
	
	@PostMapping
	public ResponseDTO<String> addEmp(@Valid @RequestBody EmpDTO empDTO) {
		return empServiceImpl.addEmp(empDTO);
	}
	
	@PutMapping("/{id}")
	public ResponseDTO<String> modifyEmp(@PathVariable("id") String id, @Valid @RequestBody EmpDTO empDTO) {
		empDTO.setEmpId(id);
		
		return empServiceImpl.modifyEmp(empDTO);
	}
	
	@PostMapping("/delete")
	public ResponseDTO<String> removeEmp(@RequestParam(value="ids[]") List<String> ids) {
		return empServiceImpl.removeEmp(ids);
	}
}
