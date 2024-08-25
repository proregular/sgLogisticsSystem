package com.sg.ls.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.sg.ls.common.CommonUtils;
import com.sg.ls.dto.ItemDTO;
import com.sg.ls.exception.CustomDatabaseException;
import com.sg.ls.vo.ItemVO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ItemDAOImpl implements ItemDAO {
	private final SqlSessionTemplate sql;
	
	@Override
	public int insertItem(ItemVO itemVO) {
		try {
			return sql.insert("Item.insertItem", itemVO);
		} catch (DataAccessException e) {
			String message = CommonUtils.costomDBErrorMessage(e);
			
			throw new CustomDatabaseException(message);
		}
	}

	@Override
	public List<ItemDTO> selectItemByNameAndCode(Map<String, Object> param) {
		try {
			return sql.selectList("Item.selectItemByNameAndCode", param);
		} catch (DataAccessException e) {
			String message = CommonUtils.costomDBErrorMessage(e);
			
			throw new CustomDatabaseException(message);
		}
	}
	
	@Override
	public int updateItem(ItemVO itemVO) {
		try {
			return sql.update("Item.updateItem", itemVO);
		} catch (DataAccessException e) {
			String message = CommonUtils.costomDBErrorMessage(e);
			
			throw new CustomDatabaseException(message);
		}
	}

	@Override
	public int deleteItem(List<String> ids) {
		try {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("ids", ids);
			
			return sql.delete("Item.deleteItem", map);
		}  catch (DataAccessException e) {
			String message = CommonUtils.costomDBErrorMessage(e);
			
			throw new CustomDatabaseException(message);
		}
	}
}
