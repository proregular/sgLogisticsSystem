package com.sg.ls.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class ResponseDTO<T> {
	private String resultCode;
	private String massage;
	private T data;
}
