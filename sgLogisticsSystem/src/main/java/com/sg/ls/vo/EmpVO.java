package com.sg.ls.vo;

import java.sql.Date;
import java.util.Objects;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EmpVO {
	private final String empId;
	private final String empPw;
	private final String empNm;
	private final String empRole;
	private final String rankCd;
	private final String deptCd;
	private final String tel;
	private final String email;
	private final Date ipsaDt;
	
	@Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final EmpVO empVo = (EmpVO) o;
        return empId == empVo.empId &&
        	empPw == empVo.empPw &&
        	empNm == empVo.empNm &&
        	empRole == empVo.empRole &&
        	rankCd == empVo.rankCd &&
        	deptCd == empVo.deptCd &&
        	tel == empVo.tel &&
        	email == empVo.email &&
        	ipsaDt == empVo.ipsaDt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, empPw, empNm, empRole, rankCd, deptCd, tel, email, ipsaDt);
    }
    
}