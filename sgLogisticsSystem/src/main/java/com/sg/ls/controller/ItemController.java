package com.sg.ls.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sg.ls.dto.ResponseDTO;
import com.sg.ls.dto.ItemDTO;
import com.sg.ls.service.ItemServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/item")
public class ItemController {
	
	@Autowired
	private ItemServiceImpl itemServiceImpl;
	
	@GetMapping
	public List<ItemDTO> getAllItem(@RequestParam(required = false, value="srch_item_nm") String name, @RequestParam(required = false, value="srch_item_cd") String code) {
		return itemServiceImpl.findItemByNameAndCode(name, code);
	}
	
	@PostMapping
	public ResponseDTO<String> addItem(@Valid @RequestBody ItemDTO itemDTO) {
		return itemServiceImpl.addItem(itemDTO);
	}
	
	@PutMapping("/{id}")
	public ResponseDTO<String> modifyItem(@PathVariable("id") String id, @Valid @RequestBody ItemDTO itemDTO) {
		itemDTO.setItemCd(id);
		return itemServiceImpl.modifyItem(itemDTO);
	}
	
	@PostMapping("/delete")
	public ResponseDTO<String> removeItem(@RequestParam(value="ids[]") List<String> ids) {
		return itemServiceImpl.removeItem(ids);
	}
	

}
