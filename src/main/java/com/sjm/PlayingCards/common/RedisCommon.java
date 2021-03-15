package com.sjm.PlayingCards.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sjm.PlayingCards.core.fightAgainstLandlords.impl.PokerBrandGamePlayer;
import com.sjm.PlayingCards.dto.RoomInformation;
import com.sjm.PlayingCards.service.RedisService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 斗地主操作redis的常用方法
 */
@Component
public class RedisCommon {
    private final RedisService redisService;
    public RedisCommon(RedisService redisService){
        this.redisService = redisService;
    }

    /**
     * 根据id获取房间信息
     * @param roomId
     * @return
     */
    public RoomInformation getRoomById(String roomId){
        String room = redisService.get(roomId);
        JSONObject jsonObject = JSON.parseObject(room);
        JSONObject pokerRoom = (JSONObject)jsonObject.get("pokerRoom");
        JSONArray gamePlayers = (JSONArray)pokerRoom.get("gamePlayers");
        String gamePlayer = JSON.toJSONString(gamePlayers);
        List<PokerBrandGamePlayer> pokerBrandGamePlayers = JSON.parseArray(gamePlayer, PokerBrandGamePlayer.class);
        RoomInformation roomInformation = JSON.parseObject(room, RoomInformation.class);
        roomInformation.getPokerRoom().setGamePlayers(pokerBrandGamePlayers);
        return roomInformation;
    }

}
