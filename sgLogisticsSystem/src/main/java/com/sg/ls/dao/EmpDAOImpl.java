package com.sg.ls.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.sg.ls.common.CommonUtils;
import com.sg.ls.dto.EmpDTO;
import com.sg.ls.exception.CustomDatabaseException;
import com.sg.ls.vo.EmpVO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class EmpDAOImpl implements EmpDAO {
	private final SqlSessionTemplate sql;
	
	@Override
	public int insertEmp(EmpVO empVO) {
		try {
			return sql.insert("Emp.insertEmp", empVO);
		} catch (DataAccessException e) {
			String message = CommonUtils.costomDBErrorMessage(e);
			
			throw new CustomDatabaseException(message);
		}
	}

	@Override
	public List<EmpDTO> selectEmpByNameAndCode(Map<String, Object> param) {
		try {
			return sql.selectList("Emp.selectEmpByNameAndCode", param);
		} catch (DataAccessException e) {
			String message = CommonUtils.costomDBErrorMessage(e);
			
			throw new CustomDatabaseException(message);
		}
	}
	
	@Override
	public int updateEmp(EmpVO empVO) {
		try {
			return sql.update("Emp.updateEmp", empVO);
		} catch (DataAccessException e) {
			String message = CommonUtils.costomDBErrorMessage(e);
			
			throw new CustomDatabaseException(message);
		}
	}

	@Override
	public int deleteEmp(List<String> ids) {
		try {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("ids", ids);
			
			return sql.delete("Emp.deleteEmp", map);
		}  catch (DataAccessException e) {
			String message = CommonUtils.costomDBErrorMessage(e);
			
			throw new CustomDatabaseException(message);
		}
	}
}