package com.sjm.PlayingCards.core.fightAgainstLandlords.test;


import com.sjm.PlayingCards.core.fightAgainstLandlords.impl.PokerBrand;

import java.util.List;

public class PlayResult {
    //下家
    private PlayResult nextBrand;
    //上家
    private PlayResult preBrand;
    //手中的牌
    private List<PokerBrand> list;
    //出牌权在哪里 -1 上家 0 自己 1 下家
    private int rightIndex;
    //是否为地主
    private boolean isLandlord;
    //牌的数量
    private int brandNum;

    public PlayResult getNextBrand() {
        return nextBrand;
    }

    public void setNextBrand(PlayResult nextBrand) {
        this.nextBrand = nextBrand;
    }

    public PlayResult getPreBrand() {
        return preBrand;
    }

    public void setPreBrand(PlayResult preBrand) {
        this.preBrand = preBrand;
    }

    public List<PokerBrand> getList() {
        return list;
    }

    public void setList(List<PokerBrand> list) {
        this.list = list;
    }

    public int getRightIndex() {
        return rightIndex;
    }

    public void setRightIndex(int rightIndex) {
        this.rightIndex = rightIndex;
    }

    public boolean isLandlord() {
        return isLandlord;
    }

    public void setLandlord(boolean landlord) {
        isLandlord = landlord;
    }

    public int getBrandNum() {
        return brandNum;
    }

    public void setBrandNum(int brandNum) {
        this.brandNum = brandNum;
    }

    @Override
    public String toString() {
        return "PlayResult{" +
                "nextBrand=" + nextBrand +
                ", preBrand=" + preBrand +
                ", list=" + list +
                ", rightIndex=" + rightIndex +
                ", isLandlord=" + isLandlord +
                ", brandNum=" + brandNum +
                '}';
    }
}
