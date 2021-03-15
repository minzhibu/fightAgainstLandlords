package com.sjm.PlayingCards.core.fightAgainstLandlords.impl;


import com.sjm.PlayingCards.core.fightAgainstLandlords.DealCards;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PokerDealCards implements DealCards<PokerBrandGamePlayer,PokerBrand> {

    @Override
    public List<PokerBrand> dealCards(List<PokerBrandGamePlayer> pokerBrandGamePlayers, List<PokerBrand> pokerBrands) {
        int size = 17;
        int num = pokerBrandGamePlayers.size();
        IntStream.range(0, num).mapToObj(i -> {
            PokerBrandGamePlayer gamePlayer = pokerBrandGamePlayers.get(i);
            gamePlayer.obtain(new ArrayList<>(pokerBrands.subList(i * size, (i + 1) * size)));
            return gamePlayer;
        }).collect(Collectors.toList());
        return pokerBrands.subList(num * size, pokerBrands.size());
    }

}
