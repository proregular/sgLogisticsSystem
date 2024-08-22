package com.sg.ls.service;

import java.util.List;

import com.sg.ls.dto.RankDTO;
import com.sg.ls.dto.ResponseDTO;

public interface RankService {
ResponseDTO<String> addRank(RankDTO rankDTO);
	
	List<RankDTO> findRankByNameAndCode(String name, String code);
	
	ResponseDTO<String> modifyRank(RankDTO rankDTO);
	
	ResponseDTO<String> removeRank(List<String> ids);
}
