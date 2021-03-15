package com.sjm.PlayingCards.core.fightAgainstLandlords.util;


import com.sjm.PlayingCards.core.fightAgainstLandlords.pokerEnum.PokerNameEnum;
import com.sjm.PlayingCards.core.fightAgainstLandlords.pokerEnum.PokerTypeEnum;

public class PokerSort {
    private PokerNameEnum pokerNameEnum;
    private PokerTypeEnum pokerTypeEnum;

    PokerSort(PokerNameEnum pokerNameEnum, PokerTypeEnum pokerTypeEnum) {
        this.pokerNameEnum = pokerNameEnum;
        this.pokerTypeEnum = pokerTypeEnum;
    }

    public PokerNameEnum getPokerNameEnum() {
        return pokerNameEnum;
    }

    public PokerTypeEnum getPokerTypeEnum() {
        return pokerTypeEnum;
    }

    String getName(){
        return pokerTypeEnum.getType() + pokerNameEnum.getName();
    }
    int getSort(){
        return pokerTypeEnum.getSort() + (pokerNameEnum.getSort() * 4);
    }
}
