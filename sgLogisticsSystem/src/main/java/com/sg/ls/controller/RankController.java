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

import com.sg.ls.dto.RankDTO;
import com.sg.ls.dto.ResponseDTO;
import com.sg.ls.service.RankServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/rank")
public class RankController {
	
	@Autowired
	private RankServiceImpl rankServiceImpl;
	
	@GetMapping
	public List<RankDTO> getAllRank(@RequestParam(required = false, value="srch_rank_nm") String name, @RequestParam(required = false, value="srch_rank_cd") String code) {
		return rankServiceImpl.findRankByNameAndCode(name, code);
	}
	
	@PostMapping
	public ResponseDTO<String> addRank(@Valid @RequestBody RankDTO rankDTO) {
		return rankServiceImpl.addRank(rankDTO);
	}
	
	@PutMapping("/{id}")
	public ResponseDTO<String> modifyRank(@PathVariable("id") String id, @Valid @RequestBody RankDTO rankDTO) {
		rankDTO.setRankCd(id);
		return rankServiceImpl.modifyRank(rankDTO);
	}
	
	@PostMapping("/delete")
	public ResponseDTO<String> removeRank(@RequestParam(value="ids[]") List<String> ids) {
		return rankServiceImpl.removeRank(ids);
	}
	
}
