package com.sg.ls.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sg.ls.dto.ResponseDTO;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ExceptionController {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseDTO<String> methodValidException(MethodArgumentNotValidException e
			, HttpServletRequest request) {

		BindingResult bindingResult = e.getBindingResult();
		
		String errCode = bindingResult.getFieldError().getCode();
		String errMsg = bindingResult.getFieldError().getDefaultMessage();
		String errField = bindingResult.getFieldError().getField();
		
		String message = "에러필드: " + errField + " 에러코드: " + errCode + " 에러내용: " + errMsg;
		
		ResponseDTO<String> responseDTO = new ResponseDTO("FAIL", message, errField);
		
		return responseDTO;
	}
}
