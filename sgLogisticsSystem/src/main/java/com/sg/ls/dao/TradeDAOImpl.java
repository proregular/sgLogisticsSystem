package com.sg.ls.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.sg.ls.common.CommonUtils;
import com.sg.ls.dto.TradeDTO;
import com.sg.ls.exception.CustomDatabaseException;
import com.sg.ls.vo.TradeVO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class TradeDAOImpl implements TradeDAO {
	private final SqlSessionTemplate sql;
	
	@Override
	public int insertTrade(TradeVO tradeVO) {
		try {
			return sql.insert("Trade.insertTrade", tradeVO);
		} catch (DataAccessException e) {
			String message = CommonUtils.costomDBErrorMessage(e);
			
			throw new CustomDatabaseException(message);
		}
	}

	@Override
	public List<TradeDTO> selectTradeByNameAndCode(Map<String, Object> param) {
		try {
			return sql.selectList("Trade.selectTradeByNameAndCode", param);
		} catch (DataAccessException e) {
			String message = CommonUtils.costomDBErrorMessage(e);
			
			throw new CustomDatabaseException(message);
		}
	}
	
	@Override
	public int updateTrade(TradeVO tradeVO) {
		try {
			return sql.update("Trade.updateTrade", tradeVO);
		} catch (DataAccessException e) {
			String message = CommonUtils.costomDBErrorMessage(e);
			
			throw new CustomDatabaseException(message);
		}
	}

	@Override
	public int deleteTrade(List<String> ids) {
		try {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("ids", ids);
			
			return sql.delete("Trade.deleteTrade", map);
		}  catch (DataAccessException e) {
			String message = CommonUtils.costomDBErrorMessage(e);
			
			throw new CustomDatabaseException(message);
		}
	}
}
