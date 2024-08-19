package com.sg.ls.common;

import java.sql.SQLException;

import org.springframework.dao.DataAccessException;

public class CommonUtils {
	public static String costomDBErrorMessage(DataAccessException e) {
		SQLException se = (SQLException)e.getRootCause();
		int errorCode = se.getErrorCode();
		String message = "";
		
		switch(errorCode) {
			case 1062:
				message = "중복된 PK값이 존재합니다.";
				break;
			default:
				message = "알 수 없는 오류입니다.";
		}
		
		return "에러코드: " + errorCode + " 에러내용: " + message;
	}
}
