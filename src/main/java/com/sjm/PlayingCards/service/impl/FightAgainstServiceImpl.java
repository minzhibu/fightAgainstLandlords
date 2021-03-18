package com.sjm.PlayingCards.service.impl;

import com.sjm.PlayingCards.common.CommonResult;
import com.sjm.PlayingCards.common.RedisCommon;
import com.sjm.PlayingCards.core.fightAgainstLandlords.impl.PokerBrandGamePlayer;
import com.sjm.PlayingCards.core.fightAgainstLandlords.impl.PokerRoom;
import com.sjm.PlayingCards.dto.FightAgainstInformation;
import com.sjm.PlayingCards.dto.RoomInformation;
import com.sjm.PlayingCards.service.FightAgainstService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FightAgainstServiceImpl implements FightAgainstService {

    private final RedisCommon redisCommon;

    public FightAgainstServiceImpl(RedisCommon redisCommon) {
        this.redisCommon = redisCommon;
    }

    public FightAgainstInformation getInformation(Map<String,String> map){
        return new FightAgainstInformation();
    }

    @Override
    public CommonResult isPrepare(String roomId, String userId) {
        RoomInformation roomById = redisCommon.getRoomById(roomId);
        PokerRoom pokerRoom = roomById.getPokerRoom();
        List<PokerBrandGamePlayer> gamePlayers = pokerRoom.getGamePlayers();
        if(gamePlayers.size() ==3 ){
            for(PokerBrandGamePlayer pokerBrandGamePlayer : gamePlayers ){
              if (pokerBrandGamePlayer.getState()==0) return CommonResult.failed("未准备");
            }
        }else{
            return CommonResult.failed("人员不足");
        }
        return null;
    }
}
