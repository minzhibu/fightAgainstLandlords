package com.sjm.PlayingCards.service;

import com.sjm.PlayingCards.dto.FightAgainstInformation;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 斗地主服务
 */
@Service
public interface FightAgainstService {

    FightAgainstInformation getInformation(Map<String,String> map);
}
