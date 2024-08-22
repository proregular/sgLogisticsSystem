package com.sg.ls.dao;

import java.util.List;
import java.util.Map;

import com.sg.ls.dto.DeptDTO;
import com.sg.ls.vo.DeptVO;

public interface DeptDAO {
	List<DeptDTO> selectDeptByNameAndCode(Map<String, Object> param);
	int insertDept(DeptVO deptVO);
	int updateDept(DeptVO deptVO);
	int deleteDept(List<String> ids);
}
