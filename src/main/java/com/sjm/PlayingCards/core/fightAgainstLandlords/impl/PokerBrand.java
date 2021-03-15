package com.sjm.PlayingCards.core.fightAgainstLandlords.impl;


import com.sjm.PlayingCards.core.fightAgainstLandlords.Brand;
import com.sjm.PlayingCards.core.fightAgainstLandlords.pokerEnum.PokerKingTypeEnum;
import com.sjm.PlayingCards.core.fightAgainstLandlords.pokerEnum.PokerNameEnum;
import com.sjm.PlayingCards.core.fightAgainstLandlords.pokerEnum.PokerTypeEnum;

import java.util.Objects;
import java.util.UUID;

/**
 * 斗地主扑克牌
 */
public class PokerBrand implements Brand {
    private final String id;
    private final String pokeType;
    private final String pokeName;

    public PokerBrand(PokerTypeEnum pokeType, PokerNameEnum pokeName) {
        this.pokeType = pokeType.getType();
        this.pokeName = pokeName.getName();
        this.id = UUID.randomUUID().getLeastSignificantBits() + "";
    }
    public PokerBrand(PokerKingTypeEnum pokeType) {
        this.pokeType = pokeType.getType();
        this.pokeName = "王";
        this.id = UUID.randomUUID().getLeastSignificantBits() + "";
    }

    public String getPokeType() {
        return pokeType;
    }

    public String getPokeName() {
        return pokeName;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "PokerBrand{" +
                "pokeType='" + pokeType + '\'' +
                ", pokeName='" + pokeName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PokerBrand that = (PokerBrand) o;
        return pokeType.equals(that.pokeType) &&
                pokeName.equals(that.pokeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pokeType, pokeName);
    }

}
