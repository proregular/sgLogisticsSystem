package com.sg.ls.vo;

import java.util.Objects;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TradeVO {
	private final String trCd;
	private final String trNm;
	private final String ceoNm;
	private final String addr;
	private final String upte;
	private final String trNum;
	private final String tel;
	private final String fax;
	private final String jongmok;
	
	@Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final TradeVO tradeVo = (TradeVO) o;
        return trCd == tradeVo.trCd &&
        	trNm == tradeVo.trNm &&
        	ceoNm == tradeVo.ceoNm &&
            addr == tradeVo.addr &&
            upte == tradeVo.upte &&
            trNum == tradeVo.trNum &&
            tel == tradeVo.tel &&
            fax == tradeVo.fax &&
            jongmok == tradeVo.jongmok;
    }

    @Override
    public int hashCode() {
        return Objects.hash(trCd, trNm, ceoNm, addr, upte, trNum, tel, fax, jongmok);
    }
    
}
