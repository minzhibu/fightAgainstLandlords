package com.sjm.PlayingCards.service;

import com.sjm.PlayingCards.common.CommonResult;
import com.sjm.PlayingCards.dto.FightAgainstInformation;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 斗地主服务
 */
@Service
public interface FightAgainstService {

    FightAgainstInformation getInformation(Map<String,String> map);

    /**
     * 当前房间用户状态
     * @param roomId 房间Id
     * @param userId 用户Id
     * @return CommonResult
     */
    CommonResult isPrepare(String roomId, String userId);
}
