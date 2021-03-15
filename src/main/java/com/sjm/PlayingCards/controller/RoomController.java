package com.sjm.PlayingCards.controller;

import com.sjm.PlayingCards.common.CommonResult;
import com.sjm.PlayingCards.service.RoomService;
import org.springframework.web.bind.annotation.*;

/**
 * 房间控制器
 */
@RestController
@RequestMapping("/room")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    /**
     * 玩家进入房间
     * @param userId
     */
    @GetMapping("/{roomId}/{userId}")
    public CommonResult inRoom(@PathVariable("roomId")String roomId, @PathVariable("userId") String userId){
        return roomService.inRoom(roomId,userId);
    }

    /**
     * 创建房间
     * @return
     */
    @PostMapping("/{userId}")
    public CommonResult createRoom(@PathVariable("userId") String userId){
        return roomService.createRoom(userId);
    }

    /**
     * 开始游戏
     * @param roomId 房间id
     * @param userId 用户id
     * @return
     */
    @GetMapping("/start/{roomId}/{userId}")
    public CommonResult startGame(@PathVariable("roomId")String roomId, @PathVariable("userId") String userId){
        return roomService.startGame(roomId,userId);
    }
}

