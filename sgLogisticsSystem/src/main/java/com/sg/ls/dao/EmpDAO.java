package com.sg.ls.dao;

import java.util.List;
import java.util.Map;

import com.sg.ls.dto.EmpDTO;
import com.sg.ls.vo.EmpVO;

public interface EmpDAO {
	List<EmpDTO> selectEmpByNameAndCode(Map<String, Object> param);
	int insertEmp(EmpVO empVO);
	int updateEmp(EmpVO empVO);
	int deleteEmp(List<String> ids);
}
