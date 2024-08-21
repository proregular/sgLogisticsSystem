package com.sg.ls.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping
	public List<TradeDTO> getAllTrade(@RequestParam(required = false, value="srch_tr_nm") String name, @RequestParam(required = false, value="srch_tr_cd") String code) {
		return tradeServiceImpl.findTradeByNameAndCode(name, code);
	}
	
	@PostMapping
	public ResponseDTO<String> addTrade(@Valid @RequestBody TradeDTO tradeDTO) {
		return tradeServiceImpl.addTrade(tradeDTO);
	}
	
	@PutMapping("/{id}")
	public ResponseDTO<String> modifyTrade(@PathVariable("id") String id, @Valid @RequestBody TradeDTO tradeDTO) {
		tradeDTO.setTrCd(id);
		return tradeServiceImpl.modifyTrade(tradeDTO);
	}
	
	@PostMapping("/delete")
	public ResponseDTO<String> removeTrade(@RequestParam(value="ids[]") List<String> ids) {
		return tradeServiceImpl.removeTrade(ids);
	}
	

}
