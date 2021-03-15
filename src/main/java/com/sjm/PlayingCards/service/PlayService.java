package com.sjm.PlayingCards.service;

import com.sjm.PlayingCards.common.CommonResult;

public interface PlayService {

    /**
     * 抢地主
     * @param roomId 房间id
     * @param userId 当前抢地主的id
     * @param robLandlord 当前人是否抢地主
     * @return CommonResult
     */
    CommonResult grab(String roomId,String userId,boolean robLandlord);
}
