package com.sjm.PlayingCards.core.fightAgainstLandlords.impl;


import com.sjm.PlayingCards.core.fightAgainstLandlords.ShuffleTheCards;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 斗地主洗牌器
 */
public class PokerShuffleTheCards implements ShuffleTheCards<PokerBrand> {
    @Override
    public List<PokerBrand>  shuffleTheCards(List<PokerBrand> brands) {
        return new Random().ints(0, brands.size()).distinct().limit(54).mapToObj(brands::get).collect(Collectors.toList());
    }
}
