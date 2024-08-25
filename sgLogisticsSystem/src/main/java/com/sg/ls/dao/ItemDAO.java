package com.sg.ls.dao;

import java.util.List;
import java.util.Map;

import com.sg.ls.dto.ItemDTO;
import com.sg.ls.vo.ItemVO;

public interface ItemDAO {
	List<ItemDTO> selectItemByNameAndCode(Map<String, Object> param);
	int insertItem(ItemVO itemVO);
	int updateItem(ItemVO itemVO);
	int deleteItem(List<String> ids);
}
