package com.sg.ls.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmpDTO {
	private String empId;
	private String empPw;
	private String empNm;
	private String empRole;
	private String rankCd;
	private String deptCd;
}
