package dybe.clan.tftapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Summoner {
    @Id
    private String id;

    private String name;

    private int level;

    private String tftTier;

    private String tftRank;

    private int tftWins;

    private int tftLosses;

    public Summoner(String id, String name, int level, String tftTier, String tftRank, int tftWins, int tftLosses) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.tftTier = tftTier;
        this.tftRank = tftRank;
        this.tftWins = tftWins;
        this.tftLosses = tftLosses;
    }

    protected Summoner() {

    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getLevel() {
        return this.level;
    }

    public String getTftTier() {
        return tftTier;
    }

    public String getTftRank() {
        return tftRank;
    }

    public int getTftWins() {
        return tftWins;
    }

    public int getTftLosses() {
        return tftLosses;
    }

}
