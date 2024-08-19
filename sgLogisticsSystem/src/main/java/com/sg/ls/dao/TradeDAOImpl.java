package com.sg.ls.dao;

import java.sql.SQLException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.sg.ls.common.CommonUtils;
import com.sg.ls.exception.CustomDatabaseException;
import com.sg.ls.vo.TradeVO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class TradeDAOImpl implements TradeDAO {
	private final SqlSessionTemplate sql;
	
	@Override
	public int insertTrade(TradeVO tradeVO) {
		// TODO Auto-generated method stub
		try {
			return sql.insert("Trade.insertTrade", tradeVO);
		} catch (DataAccessException e) {
			String message = CommonUtils.costomDBErrorMessage(e);
			
			throw new CustomDatabaseException(message);
		}
	}

}
