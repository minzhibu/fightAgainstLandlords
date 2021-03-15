package com.sjm.PlayingCards.core.fightAgainstLandlords;

import java.util.List;

/**
 * 洗牌
 */
@FunctionalInterface
public interface ShuffleTheCards<T> {

    List<T> shuffleTheCards(List<T> brands);
}
