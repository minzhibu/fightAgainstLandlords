package com.sjm.PlayingCards.service;

import com.sjm.PlayingCards.common.CommonResult;

/**
 * 房间
 */
public interface RoomService {

    /**
     * 创建房间
     * @return
     */
    CommonResult createRoom(String userId);

    /**
     * 进入房间
     * @param roomId 房间id
     * @param userId 用户id
     * @return
     */
    CommonResult inRoom(String roomId, String userId);


    /**
     * 开始游戏
     * @param roomId 房间id
     * @param userId 用户id (只有房主才有开始游戏的权力)
     * @return
     */
    CommonResult startGame(String roomId,String userId);
}
