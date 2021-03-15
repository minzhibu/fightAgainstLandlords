package com.sjm.PlayingCards.core.fightAgainstLandlords.impl;
/*
 *@program:gameDemo
 *@author: songjiamin
 *@Time: 2021/1/8  14:32
 * 判断类型
 */


import com.sjm.PlayingCards.core.fightAgainstLandlords.JudgeBrandType;
import com.sjm.PlayingCards.core.fightAgainstLandlords.pokerEnum.OutBrandType;
import com.sjm.PlayingCards.core.fightAgainstLandlords.util.PokerSortRule;

import java.util.ArrayList;
import java.util.List;

public class PokerJudgeBrandType implements JudgeBrandType<PokerBrand> {
    private final PokerSort pokerSort = new PokerSort();

    @Override
    public OutBrandType judgeBrandType(List<PokerBrand> brands) {
        pokerSort.sort(brands);
        OutBrandType outBrandType = OutBrandType.NOT_MATCH;
        //判断是否为单牌
        if(brands.size() == 1){
            outBrandType = OutBrandType.SINGLE;
        //判断是否为对子
        } else if(isDouble(brands)){
            outBrandType = OutBrandType.DOUBLE;
        //判断是否为三带一
        } else if (isThreeBelts(brands)) {
            outBrandType = OutBrandType.THREE_BELTS;
        //判断是否为顺子
        } else if (isEven(brands,5)){
            outBrandType = OutBrandType.EVEN;
        //是否为炸弹
        } else if (isBomb(brands)) {
            outBrandType = OutBrandType.BOMB;
        //判断是否为连队
        } else if(isCouple(brands)){
            outBrandType = OutBrandType.COUPLE;
        //是否为飞机
        } else if(isAircraft(brands)){
            outBrandType = OutBrandType.AIRCRAFT;
        }
        return outBrandType;
    }

    /**
     * 判断是否为对子
     * @param brands
     * @return
     */
    private boolean isDouble(List<PokerBrand> brands){
        boolean result = false;
        if(brands.size() == 2){
            String pokeName = brands.get(0).getPokeName();
            String pokeName1 = brands.get(1).getPokeName();
            result = pokeName.equals(pokeName1) && PokerSortRule.getNameInt(pokeName) < 13;
        }
        return result;
    }

    /**
     * 判断是否为三带一
     * @param brands
     * @return
     */
    private boolean isThreeBelts(List<PokerBrand> brands){
        boolean result = false;
        if(brands.size() == 4){
            PokerBrand pokerBrand = brands.get(0);
            int size = 0;
            for(int i = 1; i < brands.size(); i++){
                if(brands.get(i).getPokeName().equals(pokerBrand.getPokeType())){
                    size++;
                }
                pokerBrand = brands.get(i);
            }
            if(size == 2){
                result = true;
            }
        }
        return result;
    }

    /**
     * 判断是否为顺子
     */
    private boolean isEven(List<PokerBrand> brands,int nun){
        boolean result = false;
        //排序
        if(brands.size() > nun){
            PokerBrand pokerBrand = brands.get(0);
            int index = 1;
            for(int i = 1; i < brands.size(); i++){
                PokerBrand pokerBrand1 = brands.get(i);
                if(PokerSortRule.getNameInt(pokerBrand1.getPokeName()) - PokerSortRule.getNameInt(pokerBrand.getPokeName()) != 1){
                    break;
                }
                pokerBrand = pokerBrand1;
                index++;
            }
            if(index == brands.size()){
                result = true;
            }
        }
        return result;
    }

    /**
     * 判断是否为炸弹
     * @param brands
     * @return
     */
    private boolean isBomb(List<PokerBrand> brands){
        boolean result = false;
        if(brands.size() == 4){
            PokerBrand pokerBrand = brands.get(0);
            int index = 1;
            for(int i = 1; i < brands.size(); i++){
                PokerBrand pokerBrand1 = brands.get(i);
                if(!pokerBrand.getPokeName().equals(pokerBrand1.getPokeName())){
                    break;
                }
                index++;
            }
            if(index == brands.size()){
                result = true;
            }
        }
        if(brands.size() == 2){
            PokerBrand pokerBrand = brands.get(0);
            PokerBrand pokerBrand1 = brands.get(1);
            if("王".equals(pokerBrand.getPokeName()) && "王".equals(pokerBrand1.getPokeName())){
                result =  true;
            }
        }
        return result;
    }

    /**
     * 判断是否为连队
     * @param brands
     * @return
     */
    private boolean isCouple(List<PokerBrand> brands){
        boolean result = false;
        if(brands.size() > 6 && brands.size() % 2 == 0){
            int index = 1;
            for(int i = 0; i < brands.size(); i += 2){
                PokerBrand pokerBrand = brands.get(i);
                PokerBrand pokerBrand1 = brands.get(i + 1);
                if(!pokerBrand.getPokeName().equals(pokerBrand1.getPokeName())){
                    break;
                }
                index++;
            }
            if(index == brands.size() / 2){
                result = true;
            }
        }
        return result;
    }

    /**
     * 判断是否为飞机
     * @param brands
     * @return
     */
    private boolean isAircraft(List<PokerBrand> brands){
        boolean result = false;
        int size = brands.size();
        if(size > 8 && size % 4 == 0){
            List<PokerBrand> temp = new ArrayList<>();
            PokerBrand pokerBrand = brands.get(0);
            int index = 0;
            for(int i = 1; i < size; i++){
                PokerBrand pokerBrand1 = brands.get(i);
                String pokeName = pokerBrand.getPokeName();
                String pokeName1 = pokerBrand1.getPokeName();
                if(pokeName.equals(pokeName1)){
                    index++;
                }else if (index == 3){
                    temp.add(pokerBrand);
                    if(temp.size() > 2 && !isEven(temp,2)){
                        if(temp.size() == 2){
                            temp.remove(0);
                        }else{
                            temp.remove(pokerBrand);
                        }
                    }
                    index = 0;
                }else{
                    index = 0;
                }
                pokerBrand = pokerBrand1;
            }
            if(size / 4 == temp.size() && isEven(temp,2)){
                result = true;
            }
        }
        return result;
    }
}
