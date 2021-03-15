package com.sjm.PlayingCards.controller;

import com.sjm.PlayingCards.common.CommonResult;
import com.sjm.PlayingCards.service.PlayService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 玩游戏的控制器
 */
@RestController
@RequestMapping("playGame")
public class PlayController {

    private final PlayService playService;

    public PlayController(PlayService playService) {
        this.playService = playService;
    }

    /**
     * 抢地主
     * @param roomId 房间id
     * @param userId 用户id
     * @return
     */
    @GetMapping("/grab/{roomId}/{userId}")
    public CommonResult grab(@PathVariable("roomId") String roomId,@PathVariable("userId") String userId,boolean robLandlord){
        return playService.grab(roomId,userId,robLandlord);
    }
}
