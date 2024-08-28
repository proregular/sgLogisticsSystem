package com.sg.ls.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sg.ls.dao.EmpDAOImpl;
import com.sg.ls.dto.ResponseDTO;
import com.sg.ls.dto.EmpDTO;
import com.sg.ls.exception.CustomDatabaseException;
import com.sg.ls.vo.EmpVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpServiceImpl implements EmpService {
	private final EmpDAOImpl empDAOImpl;
	
	@Override
	public ResponseDTO<String> addEmp(EmpDTO empDTO) {
		EmpVO empVO = new EmpVO(
				empDTO.getEmpId(),
				empDTO.getEmpPw(),
				empDTO.getEmpNm(),
				empDTO.getEmpRole(),
				empDTO.getRankCd(),
				empDTO.getDeptCd(),
				empDTO.getTel(),
				empDTO.getEmail(),
				empDTO.getIpsaDt()
				);
		
		ResponseDTO<String> responseDTO = new ResponseDTO("FAIL", "실패", "");
		
		try {
			int result = empDAOImpl.insertEmp(empVO);
			
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
	public List<EmpDTO> findEmpByNameAndCode(String name, String code) {
		Map<String, Object> param = new HashMap<>();
		param.put("name", name);
		param.put("code", code);
		
		return empDAOImpl.selectEmpByNameAndCode(param);
	}

	@Override
	public ResponseDTO<String> modifyEmp(EmpDTO empDTO) {
		EmpVO empVO = new EmpVO(
				empDTO.getEmpId(),
				null,
				empDTO.getEmpNm(),
				empDTO.getEmpRole(),
				empDTO.getRankCd(),
				empDTO.getDeptCd(),
				empDTO.getTel(),
				empDTO.getEmail(),
				empDTO.getIpsaDt()
				);
		
		ResponseDTO<String> responseDTO = new ResponseDTO("FAIL", "실패", "");
		
		try {
			int result = empDAOImpl.updateEmp(empVO);
			
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
	public ResponseDTO<String> removeEmp(List<String> ids) {
		ResponseDTO<String> responseDTO = new ResponseDTO("FAIL", "실패", "");
		
		try {
			int result = empDAOImpl.deleteEmp(ids);
			
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
