package com.sg.ls.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sg.ls.dao.TradeDAOImpl;
import com.sg.ls.dto.TradeDTO;
import com.sg.ls.dto.ResponseDTO;
import com.sg.ls.exception.CustomDatabaseException;
import com.sg.ls.repository.EmpRepository;
import com.sg.ls.vo.TradeVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TradeServiceImpl implements TradeService {
	private final TradeDAOImpl tradeDAOImpl;
	
	@Override
	public ResponseDTO<String> addTrade(TradeDTO tradeDTO) {
		TradeVO tradeVO = new TradeVO(
				tradeDTO.getTrCd(),
				tradeDTO.getTrNm(),
				tradeDTO.getCeoNm(),
				tradeDTO.getAddr(),
				tradeDTO.getUpte(),
				tradeDTO.getTrNum(),
				tradeDTO.getTel(),
				tradeDTO.getFax(),
				tradeDTO.getJongmok()
				);
		
		ResponseDTO<String> responseDTO = new ResponseDTO("FAIL", "실패", "");
		
		try {
			int result = tradeDAOImpl.insertTrade(tradeVO);
			
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
	public List<TradeDTO> findTradeByNameAndCode(String name, String code) {
		Map<String, Object> param = new HashMap<>();
		param.put("name", name);
		param.put("code", code);
		
		return tradeDAOImpl.selectTradeByNameAndCode(param);
	}

	@Override
	public ResponseDTO<String> modifyTrade(TradeDTO tradeDTO) {
		TradeVO tradeVO = new TradeVO(
				tradeDTO.getTrCd(),
				tradeDTO.getTrNm(),
				tradeDTO.getCeoNm(),
				tradeDTO.getAddr(),
				tradeDTO.getUpte(),
				tradeDTO.getTrNum(),
				tradeDTO.getTel(),
				tradeDTO.getFax(),
				tradeDTO.getJongmok()
				);
		
		ResponseDTO<String> responseDTO = new ResponseDTO("FAIL", "실패", "");
		
		try {
			int result = tradeDAOImpl.updateTrade(tradeVO);
			
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
	public ResponseDTO<String> removeTrade(List<String> ids) {
		ResponseDTO<String> responseDTO = new ResponseDTO("FAIL", "실패", "");
		
		try {
			int result = tradeDAOImpl.deleteTrade(ids);
			
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
