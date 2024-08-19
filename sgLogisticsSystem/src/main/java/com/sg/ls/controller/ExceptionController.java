package com.sg.ls.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sg.ls.dto.ResponseDTO;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseDTO<String> methodValidException(MethodArgumentNotValidException e
			, HttpServletRequest request) {

		BindingResult bindingResult = e.getBindingResult();
		
		String errCode = bindingResult.getFieldError().getCode();
		String errMsg = bindingResult.getFieldError().getDefaultMessage();
		
		String message = "에러코드: " + errCode + " 에러내용: " + errMsg;
		
		ResponseDTO<String> responseDTO = new ResponseDTO("FAIL", message, "");
		
		return responseDTO;
	}
}
