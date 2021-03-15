package com.sjm.PlayingCards.core.fightAgainstLandlords.test;


import com.sjm.PlayingCards.core.fightAgainstLandlords.impl.*;
import org.testng.annotations.Test;

import java.util.List;

public class TestPoker {
    public static void main(String[] args) {
        PokerRoom pokerRoom = new PokerRoom();
        pokerRoom.addGamePlayer(new PokerBrandGamePlayer());
        pokerRoom.addGamePlayer(new PokerBrandGamePlayer());
        pokerRoom.addGamePlayer(new PokerBrandGamePlayer());

        pokerRoom.start();
    }

    @Test
    void testPokerType(){
        PokerJudgeBrandType pokerJudgeBrandType = new PokerJudgeBrandType();
        PokerGenerate generate = new PokerGenerate();
        List<PokerBrand> generate1 = generate.generate();
    }
}
