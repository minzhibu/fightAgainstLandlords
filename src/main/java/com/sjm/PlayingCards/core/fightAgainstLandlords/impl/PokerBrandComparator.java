package com.sjm.PlayingCards.core.fightAgainstLandlords.impl;


import com.sjm.PlayingCards.core.fightAgainstLandlords.BrandComparator;
import com.sjm.PlayingCards.core.fightAgainstLandlords.pokerEnum.OutBrandType;
import com.sjm.PlayingCards.core.fightAgainstLandlords.util.PokerSortRule;

import java.util.List;

/**
 * 斗地主比较器
 */
public class PokerBrandComparator implements BrandComparator<PokerBrand, OutBrandType> {

    @Override
    public boolean comparator(List<PokerBrand> next, List<PokerBrand> now, OutBrandType type) {
        switch (type) {
            case SINGLE:
                return singleComparator(next, now);
            case DOUBLE :
                return doubleComparator(next, now);
            case EVEN :
                return evenComparator(next, now);
            case THREE_BELTS :
                return threeBeltsComparator(next, now);
            case BOMB :
                return bombComparator(next, now);
            case COUPLE:
                return coupleComparator(next, now);
            case AIRCRAFT:
                return aircraftComparator(next, now);
        }
        return false;
    }

    /**
     * 判断单牌的大小
     * @param next
     * @param now
     * @return
     */
    private boolean singleComparator(List<PokerBrand> next, List<PokerBrand> now){
        return PokerSortRule.getNameInt(next.get(0).getPokeName()) < PokerSortRule.getNameInt(now.get(0).getPokeName());
    }

    /**
     * 判断对子谁大
     * @param next
     * @param now
     * @return
     */
    private boolean doubleComparator(List<PokerBrand> next, List<PokerBrand> now){
        return PokerSortRule.getNameInt(next.get(0).getPokeName()) < PokerSortRule.getNameInt(now.get(0).getPokeName());
    }

    /**
     * 三带一谁大
     * @param next
     * @param now
     * @return
     */
    private boolean threeBeltsComparator(List<PokerBrand> next, List<PokerBrand> now){
        PokerBrand nextBrand = getThreeBelts(next);
        PokerBrand nowBrand = getThreeBelts(now);
        return PokerSortRule.getNameInt(nextBrand.getPokeName()) < PokerSortRule.getNameInt(nowBrand.getPokeName());
    }

    /**
     * 顺子的谁大
     * @param next
     * @param now
     * @return
     */
    private boolean evenComparator(List<PokerBrand> next,List<PokerBrand> now){
        return next.size() == now.size() && PokerSortRule.getNameInt(next.get(0).getPokeName()) < PokerSortRule.getNameInt(now.get(0).getPokeName());
    }

    /**
     * 判断炸弹谁大
     * @param next
     * @param now
     * @return
     */
    private boolean bombComparator(List<PokerBrand> next, List<PokerBrand> now){
        return PokerSortRule.getNameInt(next.get(0).getPokeName()) < PokerSortRule.getNameInt(now.get(0).getPokeName());
    }

    /**
     * 判断连队谁大
     * @param next
     * @param now
     * @return
     */
    private boolean coupleComparator(List<PokerBrand> next, List<PokerBrand> now){
        return next.size() == now.size() && PokerSortRule.getNameInt(next.get(0).getPokeName()) < PokerSortRule.getNameInt(now.get(0).getPokeName());
    }

    /**
     * 判断飞机谁大
     * @param next
     * @param now
     * @return
     */
    private boolean aircraftComparator(List<PokerBrand> next, List<PokerBrand> now){
        PokerBrand nextBrand = getThreeBelts(next);
        PokerBrand nowBrand = getThreeBelts(now);
        return next.size() == now.size() && PokerSortRule.getNameInt(nextBrand.getPokeName()) < PokerSortRule.getNameInt(nowBrand.getPokeName());
    }

    /**
     * 获取三带一中三的类型为什么
     * @param brands
     * @return
     */
    private PokerBrand getThreeBelts(List<PokerBrand> brands){
        PokerBrand brand = brands.get(0);
        int index = 0;
        for(int i = 1; i < brands.size(); i++){
            PokerBrand pokerBrand = brands.get(i);
            if(pokerBrand.getPokeName().equals(brand.getPokeName())){
                index++;
            }
            if(index == 3){
                break;
            }
            brand = pokerBrand;
        }
        return brand;
    }
}

