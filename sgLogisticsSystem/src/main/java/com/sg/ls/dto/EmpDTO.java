package com.sg.ls.dto;

import java.sql.Date;

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
	private String rankNm;
	private String deptCd;
	private String deptNm;
	private String tel;
	private String email;
	private Date ipsaDt;
}
