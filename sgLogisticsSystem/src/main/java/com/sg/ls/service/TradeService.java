package com.sg.ls.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sg.ls.dto.ResponseDTO;
import com.sg.ls.dto.TradeDTO;
import com.sg.ls.repository.EmpRepository;

import lombok.RequiredArgsConstructor;

public interface TradeService {
	ResponseDTO<String> addTrade(TradeDTO tradeDTO);
	
	List<TradeDTO> findTradeByNameAndCode(String name, String code);
}
