package com.sjm.PlayingCards;

import com.sjm.PlayingCards.service.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PlayingCardsApplicationTests {

    @Autowired
    private RedisService redisService;

    @Test
    void contextLoads() {
    }

    @Test
    void testRedis(){
        redisService.remove("song");
    }

}
