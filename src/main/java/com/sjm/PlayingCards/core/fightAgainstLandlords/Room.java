package com.sjm.PlayingCards.core.fightAgainstLandlords;


import com.sjm.PlayingCards.core.fightAgainstLandlords.impl.PokerBrandGamePlayer;

import java.util.List;
import java.util.Map;

/**
 * 房间
 */
public interface Room<T> {
    /**
     * 开始游戏
     */
    boolean start();

    /**
     * 添加玩家
     */
    boolean addGamePlayer(PokerBrandGamePlayer gamePlayer);

    /**
     * 出牌
     * @param brands
     */
    boolean play(List<T> brands);

    /**
     * 弃权
     */
    void waiver();

    /**
     * 抢地主
     */
    void robLandlord(boolean isRob);

    /**
     * 根据玩家id来获取数据
     */
    Map<String,Object> findDataById(long id);
}
