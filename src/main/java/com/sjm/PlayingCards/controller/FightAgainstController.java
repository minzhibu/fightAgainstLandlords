package com.sjm.PlayingCards.controller;

import com.sjm.PlayingCards.common.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 斗地主控制器
 */
@RestController
@RequestMapping("/fightAgainst")
public class FightAgainstController {

    /**
     * 根据房间id和用户id获取斗地主的状态
     * @param roomId
     * @param userId
     * @return
     */
    @GetMapping("/information/{roomId}/{userId}")
    public CommonResult getInformation(@PathVariable("roomId") String roomId, @PathVariable("userId") String userId){
        return CommonResult.success("");
    }
}
