package com.sjm.PlayingCards.core.fightAgainstLandlords.pokerEnum;

public enum PokerKingTypeEnum {
    BIG("大"),small("小");
    private final String type;
    PokerKingTypeEnum(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "PokerKingTypeEnum{" +
                "type='" + type + '\'' +
                '}';
    }
}
