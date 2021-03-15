package com.sjm.PlayingCards.core.fightAgainstLandlords;

import java.util.List;

/**
 * 比较器
 */
@FunctionalInterface
public interface BrandComparator<T,R> {

    /**
     * 判断当前出牌是否大于上次出的牌
     * @param next 上家的牌
     * @param now 当前出的牌
     * @param type 出牌的类型
     * @return 当前出牌大于上家出牌时返回true
     */
    boolean comparator(List<T> next, List<T> now, R type);
}
