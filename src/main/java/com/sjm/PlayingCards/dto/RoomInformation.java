package com.sjm.PlayingCards.dto;

import com.sjm.PlayingCards.core.fightAgainstLandlords.impl.PokerBrandGamePlayer;
import com.sjm.PlayingCards.core.fightAgainstLandlords.impl.PokerRoom;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 房间信息
 */
public class RoomInformation {
    //游玩房间
    private final PokerRoom pokerRoom;
    //房间id
    private final String id;
    //房主id
    private String homeownersId;
    //本次获取数据的人
    private String obtainId;
    private boolean toJson;
    public RoomInformation(String homeownersId){
        this.homeownersId = homeownersId;
        this.obtainId = homeownersId;
        this.toJson = true;
        this.id = UUID.randomUUID().getLeastSignificantBits() + "";
        pokerRoom = new PokerRoom();
        addGamePlayer(homeownersId);
    }
    /**
     * 添加玩家进入游戏房间
     * @param id 玩家id
     * @return boolean 进入房间是否成功
     */
    public boolean addGamePlayer(String id){
        PokerBrandGamePlayer pokerBrandGamePlayer = new PokerBrandGamePlayer(Long.parseLong(id));
        return pokerRoom.addGamePlayer(pokerBrandGamePlayer);
    }

    /**
     * 获取数据
     * @return map
     */
    public Map<String,Object> getData(){
        return pokerRoom.findDataById(Long.parseLong(obtainId));
    }

    /**
     * 开始游戏
     */
    public boolean start(){
        return pokerRoom.start();
    }

    /**
     * 查看当前状态，获取当前执行人
     * @return map
     */
    public Map<String,Object> getState(){
        Map<String,Object> map = new HashMap<>();
        int state = pokerRoom.getState();
        map.put("state",state);
        PokerBrandGamePlayer pokerBrandGamePlayer = null;
        if(state == 2){
            pokerBrandGamePlayer = pokerRoom.getGamePlayers().get(pokerRoom.getLandlordIndexTemp());
        }else if(state == 3){
            pokerBrandGamePlayer = pokerRoom.getGamePlayers().get(pokerRoom.getNowGamePlayersIndex());
        }
        map.put("gamePlayer", pokerBrandGamePlayer);
        return map;
    }

    public String getId() {
        return id;
    }

    public PokerRoom getPokerRoom() {
        if(toJson){
            return pokerRoom;
        }
        return null;
    }

    public void setToJson(boolean toJson) {
        this.toJson = toJson;
    }

    public String getHomeownersId() {
        return homeownersId;
    }

    public void setHomeownersId(String homeownersId) {
        this.homeownersId = homeownersId;
    }

    public void setObtainId(String obtainId) {
        this.obtainId = obtainId;
    }
}
