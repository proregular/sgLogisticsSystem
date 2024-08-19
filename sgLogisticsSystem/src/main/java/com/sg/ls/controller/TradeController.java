package com.sg.ls.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sg.ls.dto.ResponseDTO;
import com.sg.ls.dto.TradeDTO;
import com.sg.ls.service.TradeServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/trade")
public class TradeController {
	
	@Autowired
	private TradeServiceImpl tradeServiceImpl;
	
	@PostMapping
	public ResponseDTO<String> addTrade(@RequestBody @Valid TradeDTO tradeDTO) {
		return tradeServiceImpl.addTrade(tradeDTO);
	}
	

}
