package com.sjm.PlayingCards.service.impl;

import com.alibaba.fastjson.JSON;
import com.sjm.PlayingCards.dto.TouristInformation;
import com.sjm.PlayingCards.service.LoginService;
import com.sjm.PlayingCards.service.RedisService;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class LoginServiceImpl implements LoginService {
    private final RedisService redisService;

    public LoginServiceImpl(RedisService redisService) {
        this.redisService = redisService;
    }
    @Override
    public TouristInformation loginTourist() {
        String userId = UUID.randomUUID().getLeastSignificantBits() + "";
        String userName = "游客" + userId.substring(userId.length() - 5);
        TouristInformation touristInformation = new TouristInformation();
        touristInformation.setId(userId);
        touristInformation.setName(userName);
        touristInformation.setChip("1000");
        String tourists = JSON.toJSONString(touristInformation);
        //保持到redis中
        redisService.set(userId,tourists);
        //十分钟到期
        redisService.expire(userId, 6000);
        return touristInformation;
    }
}
