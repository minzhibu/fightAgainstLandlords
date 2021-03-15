package com.sjm.PlayingCards.core.fightAgainstLandlords.pokerEnum;

/**
 * 扑克牌名称
 */
public enum PokerNameEnum {
    TWO("2",12),THREE("3",0),FOUR("4",1),FIVE("5",2),SIX("6",3),SEVEN("7",4),EIGHT("8",5),NINE("9",6),TEN("10",7),J("J",8),Q("Q",9),K("K",10),A("A",11);

    private final String name;
    private final int sort;
    PokerNameEnum(String name,int sort){
        this.name = name;
        this.sort = sort;
    }

    public String getName() {
        return name;
    }

    public int getSort() {
        return sort;
    }

    @Override
    public String toString() {
        return "PokerNameEnum{" +
                "name='" + name + '\'' +
                '}';
    }
}
