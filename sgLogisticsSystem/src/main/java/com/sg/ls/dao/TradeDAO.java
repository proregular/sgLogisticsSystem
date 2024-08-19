package com.sg.ls.dao;

import java.util.List;

import com.sg.ls.dto.TradeDTO;
import com.sg.ls.vo.TradeVO;

public interface TradeDAO {
	//List<TradeDTO> selectTrade();
	//List<TradeDTO> selectTradeByNameAndCode(String name, String code);
	int insertTrade(TradeVO tradeVO);
	//int updateTrade(TradeVO tradeVO);
	//int removeTrade(String code);
}
