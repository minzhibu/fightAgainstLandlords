package com.sjm.PlayingCards.core.fightAgainstLandlords;

import java.util.List;

/**
 * 发牌器
 */
@FunctionalInterface
public interface DealCards<E,T> {
    List<T> dealCards(List<E> pokerBrandGamePlayers, List<T> pokerBrands);
}
