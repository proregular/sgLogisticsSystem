package com.sg.ls.vo;

import java.util.Objects;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ItemVO {
	private final String itemCd;
	private final String itemNm;
	private final String itemSd;
	private final String itemDc;
	private final Integer itemFg;
	
	@Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ItemVO tradeVo = (ItemVO) o;
        return itemCd == tradeVo.itemCd &&
        		itemNm == tradeVo.itemNm &&
        	itemSd == tradeVo.itemSd &&
            itemDc == tradeVo.itemDc &&
            itemFg == tradeVo.itemFg;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemCd, itemNm, itemSd, itemDc, itemFg);
    }
    
}
