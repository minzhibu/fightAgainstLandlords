package com.sjm.PlayingCards.service.impl;

import com.alibaba.fastjson.JSON;
import com.sjm.PlayingCards.common.CommonResult;
import com.sjm.PlayingCards.common.RedisCommon;
import com.sjm.PlayingCards.dto.RoomInformation;
import com.sjm.PlayingCards.dto.TouristInformation;
import com.sjm.PlayingCards.service.RedisService;
import com.sjm.PlayingCards.service.RoomService;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {

    private final RedisService redisService;
    private final RedisCommon redisCommon;
    public RoomServiceImpl(RedisService redisService,RedisCommon redisCommon){
        this.redisService = redisService;
        this.redisCommon = redisCommon;
    }

    @Override
    public CommonResult createRoom(String userId) {
        TouristInformation touristInformation = getTouristInformationById(userId);
        if(touristInformation == null){
            return CommonResult.failed("当前游客不存在");
        }
        RoomInformation roomInformation = new RoomInformation(userId);
        String roomId = roomInformation.getId();
        touristInformation.setRoomId(roomId);
        redisService.set(roomId,JSON.toJSONString(roomInformation));
        redisService.set(userId,JSON.toJSONString(touristInformation));
        return CommonResult.success(roomId);
    }

    @Override
    public CommonResult inRoom(String roomId, String userId) {
        try{
            TouristInformation touristInformation = getTouristInformationById(userId);
            if(touristInformation == null){
                return CommonResult.failed("当前游客不存在");
            }
            RoomInformation roomInformation = redisCommon.getRoomById(roomId);
            boolean b = roomInformation.addGamePlayer(userId);
            if(b){
                touristInformation.setRoomId(roomInformation.getId());
                redisService.set(roomId,JSON.toJSONString(roomInformation));
                redisService.set(userId,JSON.toJSONString(touristInformation));
                return CommonResult.success("进入房间成功");
            }else{
                return CommonResult.failed("进入房间失败");
            }
        }catch(Exception e){
            return CommonResult.failed("进入房间失败");
        }
    }

    @Override
    public CommonResult startGame(String roomId, String userId) {
        TouristInformation touristInformationById = getTouristInformationById(userId);
        if(touristInformationById != null){
            String roomId1 = touristInformationById.getRoomId();
            if(roomId1 != null){
                RoomInformation roomInformation = redisCommon.getRoomById(roomId);
                if(roomInformation.getHomeownersId().equals(userId)){
                    if(roomInformation.start()){
                        redisService.set(roomId,JSON.toJSONString(roomInformation));
                        return CommonResult.success("开始游戏");
                    }else{
                        return CommonResult.failed("暂无法开始游戏");
                    }
                }
            }
        }
        return CommonResult.failed("暂无法开始游戏");
    }

    /**
     * 根据id获取当前游客信息
     * @return
     */
    private TouristInformation getTouristInformationById(String userId){
        try{
            String userJson = redisService.get(userId);
            return JSON.parseObject(userJson, TouristInformation.class);
        }catch (Exception e){
            return null;
        }
    }


}

