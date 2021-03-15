package com.sjm.PlayingCards.core.fightAgainstLandlords.test;


import com.sjm.PlayingCards.core.fightAgainstLandlords.impl.PokerBrand;
import com.sjm.PlayingCards.core.fightAgainstLandlords.impl.PokerBrandGamePlayer;
import com.sjm.PlayingCards.core.fightAgainstLandlords.impl.PokerRoom;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PlayPoker {

    public static void main(String[] args) {
        PokerRoom pokerRoom = new PokerRoom();
        pokerRoom.addGamePlayer(new PokerBrandGamePlayer());
        pokerRoom.addGamePlayer(new PokerBrandGamePlayer());
        pokerRoom.addGamePlayer(new PokerBrandGamePlayer());
        pokerRoom.addGamePlayer(new PokerBrandGamePlayer());
        pokerRoom.start();
        boolean boo1 = true;
        boolean boo2 = true;
        while(boo1){
            while(boo2){
                PokerBrandGamePlayer pokerBrandGamePlayer = pokerRoom.getGamePlayers().get(pokerRoom.getLandlordIndexTemp());
                System.out.println("当前抢地主的人为" + pokerBrandGamePlayer.getPlayId());
                System.out.println("输入1抢地主，2弃权");
                String s = new Scanner(System.in).nextLine();
                pokerRoom.robLandlord("1".equals(s));
                if(pokerRoom.getState() == 3){
                    boo2 = false;
                }
            }
            boo2 = true;
            System.out.println(pokerRoom.getGamePlayers().get(pokerRoom.getLandlordIndex()).getPlayId());
            while(pokerRoom.getState() == 3){
                //当前出牌人
                int nowGamePlayersIndex = pokerRoom.getNowGamePlayersIndex();
                PokerBrandGamePlayer pokerBrandGamePlayer = pokerRoom.getGamePlayers().get(nowGamePlayersIndex);
                System.out.println("当前出牌人的为" + pokerBrandGamePlayer.getPlayId());
                List<PokerBrand> brands = pokerBrandGamePlayer.getBrands();
                System.out.println("手中的牌为:");
                brands.forEach(brand -> System.out.print(brand.getPokeName() + ","));
                System.out.println("输入1抢出牌，2弃权");
                String s = new Scanner(System.in).nextLine();
                if("1".equals(s)){
                    boolean play = true;
                    while(play){
                        System.out.println("请输入出牌的下标使用,号隔开");
                        String brand = new Scanner(System.in).nextLine();
                        String[] split = brand.split(",");
                        List<PokerBrand> collect = Arrays.stream(split).map(Integer::parseInt).map(brands::get).collect(Collectors.toList());
                        play = !pokerRoom.play(collect);
                        if(play){
                            System.out.println("出牌不和规则，请重新出牌");
                        }
                    }
                }else if("2".equals(s)){
                    pokerRoom.waiver();
                }
            }
        }
    }
}
