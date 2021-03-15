package com.sjm.PlayingCards.service.impl;

import com.sjm.PlayingCards.common.CommonResult;
import com.sjm.PlayingCards.common.RedisCommon;
import com.sjm.PlayingCards.core.fightAgainstLandlords.impl.PokerRoom;
import com.sjm.PlayingCards.dto.RoomInformation;
import com.sjm.PlayingCards.service.PlayService;
import org.springframework.stereotype.Service;

@Service
public class PlayServiceImpl implements PlayService {

    private final RedisCommon redisCommon;

    public PlayServiceImpl(RedisCommon redisCommon) {
        this.redisCommon = redisCommon;
    }

    @Override
    public CommonResult grab(String roomId, String userId,boolean robLandlord) {
        RoomInformation roomById = redisCommon.getRoomById(roomId);
        PokerRoom pokerRoom = roomById.getPokerRoom();
        //获取当前抢地主的id
        int landlordIndexTemp = pokerRoom.getLandlordIndexTemp();
        long playId = pokerRoom.getGamePlayers().get(landlordIndexTemp).getPlayId();
        long l = Long.parseLong(userId);
        //该账号是当前抢地主的人
        if(playId == l){
            pokerRoom.robLandlord(robLandlord);
        }
        return null;
    }
}
