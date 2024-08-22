package com.sg.ls.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.sg.ls.common.CommonUtils;
import com.sg.ls.dto.DeptDTO;
import com.sg.ls.exception.CustomDatabaseException;
import com.sg.ls.vo.DeptVO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class DeptDAOImpl implements DeptDAO {
	private final SqlSessionTemplate sql;
	
	@Override
	public int insertDept(DeptVO deptVO) {
		try {
			return sql.insert("Dept.insertDept", deptVO);
		} catch (DataAccessException e) {
			String message = CommonUtils.costomDBErrorMessage(e);
			
			throw new CustomDatabaseException(message);
		}
	}

	@Override
	public List<DeptDTO> selectDeptByNameAndCode(Map<String, Object> param) {
		try {
			return sql.selectList("Dept.selectDeptByNameAndCode", param);
		} catch (DataAccessException e) {
			String message = CommonUtils.costomDBErrorMessage(e);
			
			throw new CustomDatabaseException(message);
		}
	}
	
	@Override
	public int updateDept(DeptVO deptVO) {
		try {
			return sql.update("Dept.updateDept", deptVO);
		} catch (DataAccessException e) {
			String message = CommonUtils.costomDBErrorMessage(e);
			
			throw new CustomDatabaseException(message);
		}
	}

	@Override
	public int deleteDept(List<String> ids) {
		try {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("ids", ids);
			
			return sql.delete("Dept.deleteDept", map);
		}  catch (DataAccessException e) {
			String message = CommonUtils.costomDBErrorMessage(e);
			
			throw new CustomDatabaseException(message);
		}
	}
}
