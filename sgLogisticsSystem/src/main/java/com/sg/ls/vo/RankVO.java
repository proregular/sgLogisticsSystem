package com.sg.ls.vo;

import java.util.Objects;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RankVO {
	private final String rankCd;
	private final String rankNm;
	
	@Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final RankVO rankVo = (RankVO) o;
        return rankCd == rankVo.rankCd &&
        		rankNm == rankVo.rankNm ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rankCd, rankNm);
    }
}
