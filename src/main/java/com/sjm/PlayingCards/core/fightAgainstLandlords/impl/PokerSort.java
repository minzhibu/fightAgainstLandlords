package com.sjm.PlayingCards.core.fightAgainstLandlords.impl;


import com.sjm.PlayingCards.core.fightAgainstLandlords.Sort;
import com.sjm.PlayingCards.core.fightAgainstLandlords.util.PokerSortRule;

import java.util.Comparator;
import java.util.List;

public class PokerSort implements Sort<PokerBrand> {
    @Override
    public void sort(List<PokerBrand> brands) {
        brands.sort(Comparator.comparing(PokerSortRule::getSort));
    }
}
