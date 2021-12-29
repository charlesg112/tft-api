package dybe.clan.tftapi.external.match.v1.representation;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TftUnitV1 {
    @Id
    private String character_id;
    // private List<Integer> items;
    private int rarity;
    private int tier;

    protected TftUnitV1 () {}

    public String getCharacter_id() {
        return character_id;
    }

    public int getRarity() {
        return rarity;
    }

    public int getTier() {
        return tier;
    }
}
