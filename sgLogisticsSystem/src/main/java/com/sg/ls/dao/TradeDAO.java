package com.sg.ls.dao;

import java.util.List;
import java.util.Map;

import com.sg.ls.dto.TradeDTO;
import com.sg.ls.vo.TradeVO;

public interface TradeDAO {
	//List<TradeDTO> selectTrade();
	List<TradeDTO> selectTradeByNameAndCode(Map<String, Object> param);
	int insertTrade(TradeVO tradeVO);
	int updateTrade(TradeVO tradeVO);
	int deleteTrade(List<String> ids);
}
