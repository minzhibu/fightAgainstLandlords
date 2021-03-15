package com.sjm.PlayingCards.core.fightAgainstLandlords.pokerEnum;

public enum PokerTypeEnum {
    HEART("红桃",1),SPADE("黑桃",2),PLUMB_LOSSOM("梅花",3),BLOCK("方块",4);

    private final String type;
    private final int sort;

    PokerTypeEnum(String type,int sort){
        this.type = type;
        this.sort = sort;
    }

    public String getType() {
        return type;
    }

    public int getSort() {
        return sort;
    }

    @Override
    public String toString() {
        return "PokerTypeEnum{" +
                "type='" + type + '\'' +
                '}';
    }
}
