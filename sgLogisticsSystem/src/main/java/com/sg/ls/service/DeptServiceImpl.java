package com.sg.ls.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sg.ls.dao.DeptDAOImpl;
import com.sg.ls.dto.ResponseDTO;
import com.sg.ls.dto.DeptDTO;
import com.sg.ls.exception.CustomDatabaseException;
import com.sg.ls.vo.DeptVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeptServiceImpl implements DeptService {
	private final DeptDAOImpl deptDAOImpl;
	
	@Override
	public ResponseDTO<String> addDept(DeptDTO deptDTO) {
		DeptVO deptVO = new DeptVO(
				deptDTO.getDeptCd(),
				deptDTO.getDeptNm()
				);
		
		ResponseDTO<String> responseDTO = new ResponseDTO("FAIL", "실패", "");
		
		try {
			int result = deptDAOImpl.insertDept(deptVO);
			
			if(result > 0) {
				responseDTO.setResultCode("SUCCESS");
				responseDTO.setMassage("추가에 성공했습니다.");
			}
			
			return responseDTO;
		} catch (CustomDatabaseException e) {
			responseDTO.setResultCode("FAIL");
			responseDTO.setMassage("추가에 실패했습니다.\n" + e.getMessage());
			
			return responseDTO;
		}
	}

	@Override
	public List<DeptDTO> findDeptByNameAndCode(String name, String code) {
		Map<String, Object> param = new HashMap<>();
		param.put("name", name);
		param.put("code", code);
		
		return deptDAOImpl.selectDeptByNameAndCode(param);
	}

	@Override
	public ResponseDTO<String> modifyDept(DeptDTO deptDTO) {
		DeptVO deptVO = new DeptVO(
				deptDTO.getDeptCd(),
				deptDTO.getDeptNm()
				);
		
		ResponseDTO<String> responseDTO = new ResponseDTO("FAIL", "실패", "");
		
		try {
			int result = deptDAOImpl.updateDept(deptVO);
			
			if(result > 0) {
				responseDTO.setResultCode("SUCCESS");
				responseDTO.setMassage("수정에 성공했습니다.");
			}
			
			return responseDTO;
		} catch (CustomDatabaseException e) {
			responseDTO.setResultCode("FAIL");
			responseDTO.setMassage("수정에 실패했습니다.\n" + e.getMessage());
			
			return responseDTO;
		}
	}

	@Override
	public ResponseDTO<String> removeDept(List<String> ids) {
		ResponseDTO<String> responseDTO = new ResponseDTO("FAIL", "실패", "");
		
		try {
			int result = deptDAOImpl.deleteDept(ids);
			
			if(result > 0) {
				responseDTO.setResultCode("SUCCESS");
				responseDTO.setMassage("삭제에 성공했습니다.");
			}
			
			return responseDTO;
		} catch (CustomDatabaseException e) {
			responseDTO.setResultCode("FAIL");
			responseDTO.setMassage("삭제에 실패했습니다.\n" + e.getMessage());
			
			return responseDTO;
		}
	}

}

