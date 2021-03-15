package com.sjm.PlayingCards.core.fightAgainstLandlords;

import java.util.List;

/**
 * 牌生成器
 */
@FunctionalInterface
public interface Generate<T> {

    List<T> generate();
}
