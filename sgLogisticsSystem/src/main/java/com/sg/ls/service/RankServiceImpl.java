package com.sg.ls.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sg.ls.dao.RankDAOImpl;
import com.sg.ls.dto.RankDTO;
import com.sg.ls.dto.ResponseDTO;
import com.sg.ls.exception.CustomDatabaseException;
import com.sg.ls.vo.RankVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RankServiceImpl implements RankService {
	private final RankDAOImpl rankDAOImpl;
	
	@Override
	public ResponseDTO<String> addRank(RankDTO rankDTO) {
		RankVO rankVO = new RankVO(
				rankDTO.getRankCd(),
				rankDTO.getRankNm()
				);
		
		ResponseDTO<String> responseDTO = new ResponseDTO("FAIL", "실패", "");
		
		try {
			int result = rankDAOImpl.insertRank(rankVO);
			
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
	public List<RankDTO> findRankByNameAndCode(String name, String code) {
		Map<String, Object> param = new HashMap<>();
		param.put("name", name);
		param.put("code", code);
		
		return rankDAOImpl.selectRankByNameAndCode(param);
	}

	@Override
	public ResponseDTO<String> modifyRank(RankDTO rankDTO) {
		RankVO rankVO = new RankVO(
				rankDTO.getRankCd(),
				rankDTO.getRankNm()
				);
		
		ResponseDTO<String> responseDTO = new ResponseDTO("FAIL", "실패", "");
		
		try {
			int result = rankDAOImpl.updateRank(rankVO);
			
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
	public ResponseDTO<String> removeRank(List<String> ids) {
		ResponseDTO<String> responseDTO = new ResponseDTO("FAIL", "실패", "");
		
		try {
			int result = rankDAOImpl.deleteRank(ids);
			
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
