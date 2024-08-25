package com.sg.ls.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sg.ls.dao.ItemDAOImpl;
import com.sg.ls.dto.ResponseDTO;
import com.sg.ls.dto.ItemDTO;
import com.sg.ls.exception.CustomDatabaseException;
import com.sg.ls.vo.ItemVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
	private final ItemDAOImpl itemDAOImpl;
	
	@Override
	public ResponseDTO<String> addItem(ItemDTO itemDTO) {
		ItemVO itemVO = new ItemVO(
				itemDTO.getItemCd(),
				itemDTO.getItemNm(),
				itemDTO.getItemSd(),
				itemDTO.getItemDc(),
				itemDTO.getItemFg()
				);
		
		ResponseDTO<String> responseDTO = new ResponseDTO("FAIL", "실패", "");
		
		try {
			int result = itemDAOImpl.insertItem(itemVO);
			
			if(result > 0) {
				responseDTO.setResultCode("SUCCESS");
				responseDTO.setMassage("추가에 성공했습니다.");
			}
			
			return responseDTO;
		} catch (CustomDatabaseException e) {
			responseDTO.setResultCode("FAIL");
			responseDTO.setMassage("추가에 실패했습니다.\n" + e.getMessage());
			
			return responseDTO;
		}
	}

	@Override
	public List<ItemDTO> findItemByNameAndCode(String name, String code) {
		Map<String, Object> param = new HashMap<>();
		param.put("name", name);
		param.put("code", code);
		
		return itemDAOImpl.selectItemByNameAndCode(param);
	}

	@Override
	public ResponseDTO<String> modifyItem(ItemDTO itemDTO) {
		ItemVO itemVO = new ItemVO(
				itemDTO.getItemCd(),
				itemDTO.getItemNm(),
				itemDTO.getItemSd(),
				itemDTO.getItemDc(),
				itemDTO.getItemFg()
				);
		
		ResponseDTO<String> responseDTO = new ResponseDTO("FAIL", "실패", "");
		
		try {
			int result = itemDAOImpl.updateItem(itemVO);
			
			if(result > 0) {
				responseDTO.setResultCode("SUCCESS");
				responseDTO.setMassage("수정에 성공했습니다.");
			}
			
			return responseDTO;
		} catch (CustomDatabaseException e) {
			responseDTO.setResultCode("FAIL");
			responseDTO.setMassage("수정에 실패했습니다.\n" + e.getMessage());
			
			return responseDTO;
		}
	}

	@Override
	public ResponseDTO<String> removeItem(List<String> ids) {
		ResponseDTO<String> responseDTO = new ResponseDTO("FAIL", "실패", "");
		
		try {
			int result = itemDAOImpl.deleteItem(ids);
			
			if(result > 0) {
				responseDTO.setResultCode("SUCCESS");
				responseDTO.setMassage("삭제에 성공했습니다.");
			}
			
			return responseDTO;
		} catch (CustomDatabaseException e) {
			responseDTO.setResultCode("FAIL");
			responseDTO.setMassage("삭제에 실패했습니다.\n" + e.getMessage());
			
			return responseDTO;
		}
	}

}