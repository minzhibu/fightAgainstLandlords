package com.sjm.PlayingCards.core.fightAgainstLandlords;

import java.util.List;

/**
 * 玩家
 */
public interface GamePlayer<T extends Brand> {
    void obtain(List<T> list);

    List<T> out();
}
