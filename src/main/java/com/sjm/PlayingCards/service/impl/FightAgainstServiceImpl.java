package com.sjm.PlayingCards.service.impl;

import com.sjm.PlayingCards.dto.FightAgainstInformation;
import com.sjm.PlayingCards.service.FightAgainstService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class FightAgainstServiceImpl implements FightAgainstService {

    public FightAgainstInformation getInformation(Map<String,String> map){
        return new FightAgainstInformation();
    }
}
