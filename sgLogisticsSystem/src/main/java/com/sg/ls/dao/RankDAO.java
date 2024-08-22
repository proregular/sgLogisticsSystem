package com.sg.ls.dao;

import java.util.List;
import java.util.Map;

import com.sg.ls.dto.RankDTO;
import com.sg.ls.vo.RankVO;

public interface RankDAO {
	List<RankDTO> selectRankByNameAndCode(Map<String, Object> param);
	int insertRank(RankVO rankVO);
	int updateRank(RankVO rankVO);
	int deleteRank(List<String> ids);
}
