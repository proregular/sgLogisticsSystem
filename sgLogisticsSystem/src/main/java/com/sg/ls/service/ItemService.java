package com.sg.ls.service;

import java.util.List;

import com.sg.ls.dto.ResponseDTO;
import com.sg.ls.dto.ItemDTO;

public interface ItemService {
	ResponseDTO<String> addItem(ItemDTO itemDTO);
	
	List<ItemDTO> findItemByNameAndCode(String name, String code);
	
	ResponseDTO<String> modifyItem(ItemDTO itemDTO);
	
	ResponseDTO<String> removeItem(List<String> ids);
}

