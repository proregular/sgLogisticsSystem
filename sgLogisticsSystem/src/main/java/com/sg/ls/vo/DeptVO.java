package com.sg.ls.vo;

import java.util.Objects;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeptVO {
	private final String deptCd;
	private final String deptNm;
	
	@Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final DeptVO deptVo = (DeptVO) o;
        return deptCd == deptVo.deptCd &&
        		deptNm == deptVo.deptNm ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptCd, deptNm);
    }
}