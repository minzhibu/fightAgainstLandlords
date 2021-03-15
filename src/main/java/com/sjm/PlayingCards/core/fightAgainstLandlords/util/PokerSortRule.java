package com.sjm.PlayingCards.core.fightAgainstLandlords.util;


import com.sjm.PlayingCards.core.fightAgainstLandlords.impl.PokerBrand;
import com.sjm.PlayingCards.core.fightAgainstLandlords.pokerEnum.PokerNameEnum;
import com.sjm.PlayingCards.core.fightAgainstLandlords.pokerEnum.PokerTypeEnum;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class PokerSortRule {

    //类型和名称的排序号
    private static Map<String,Integer> map;

    //类型的排序号
    private static Map<String,Integer> pokerTypeMap;

    //名称的排序号
    private static Map<String,Integer> pokerNameMap;

    static{
        map = Arrays.stream(PokerNameEnum.values()).flatMap(pokerNameEnum ->
                Arrays.stream(PokerTypeEnum.values()).map(pokerTypeEnum -> new PokerSort(pokerNameEnum, pokerTypeEnum))).collect(Collectors.toMap(PokerSort::getName, PokerSort::getSort));
        map.put("小王",53);
        map.put("大王",54);
        pokerTypeMap = Arrays.stream(PokerTypeEnum.values()).collect(Collectors.toMap(PokerTypeEnum::getType, PokerTypeEnum::getSort));

        pokerNameMap = Arrays.stream(PokerNameEnum.values()).collect(Collectors.toMap(PokerNameEnum::getName, PokerNameEnum::getSort));

        pokerNameMap.put("王",13);
    }
    //查询扑克牌的排序号
    public static int getSort(PokerBrand brand){
        return map.get(brand.getPokeType() + brand.getPokeName());
    }

    //查询类型的排序号
    public static int getTypeInt(String type){
        return pokerTypeMap.get(type);
    }

    //查询名称的排序号
    public static int getNameInt(String name){
        return pokerNameMap.get(name);
    }
}
