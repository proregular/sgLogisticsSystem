package com.sg.ls.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.sg.ls.common.CommonUtils;
import com.sg.ls.dto.RankDTO;
import com.sg.ls.exception.CustomDatabaseException;
import com.sg.ls.vo.RankVO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class RankDAOImpl implements RankDAO {
	private final SqlSessionTemplate sql;
	
	@Override
	public int insertRank(RankVO rankVO) {
		try {
			return sql.insert("Rank.insertRank", rankVO);
		} catch (DataAccessException e) {
			String message = CommonUtils.costomDBErrorMessage(e);
			
			throw new CustomDatabaseException(message);
		}
	}

	@Override
	public List<RankDTO> selectRankByNameAndCode(Map<String, Object> param) {
		try {
			return sql.selectList("Rank.selectRankByNameAndCode", param);
		} catch (DataAccessException e) {
			String message = CommonUtils.costomDBErrorMessage(e);
			
			throw new CustomDatabaseException(message);
		}
	}
	
	@Override
	public int updateRank(RankVO rankVO) {
		try {
			return sql.update("Rank.updateRank", rankVO);
		} catch (DataAccessException e) {
			String message = CommonUtils.costomDBErrorMessage(e);
			
			throw new CustomDatabaseException(message);
		}
	}

	@Override
	public int deleteRank(List<String> ids) {
		try {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("ids", ids);
			
			return sql.delete("Rank.deleteRank", map);
		}  catch (DataAccessException e) {
			String message = CommonUtils.costomDBErrorMessage(e);
			
			throw new CustomDatabaseException(message);
		}
	}
}