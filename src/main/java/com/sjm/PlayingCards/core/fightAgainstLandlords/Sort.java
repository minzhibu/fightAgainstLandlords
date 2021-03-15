package com.sjm.PlayingCards.core.fightAgainstLandlords;

import java.util.List;

/**
 * 排序
 * @param <T>
 */
@FunctionalInterface
public interface Sort<T> {
    void sort(List<T> brands);
}
