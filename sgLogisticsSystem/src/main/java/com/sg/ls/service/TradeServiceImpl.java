package com.sg.ls.service;

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
				responseDTO.setMassage("저장에 성공했습니다.");
			}
			
			return responseDTO;
		} catch (CustomDatabaseException e) {
			responseDTO.setResultCode("FAIL");
			responseDTO.setMassage("저장에 실패했습니다.\n" + e.getMessage());
			
			return responseDTO;
		}
		
	}

}
