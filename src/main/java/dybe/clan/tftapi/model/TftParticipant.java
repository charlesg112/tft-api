package dybe.clan.tftapi.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class TftParticipant {

    @Id
    private String name;

    private int totalDamageToPlayers;

    private int level;

    private int goldLeft;

    @OneToMany
    private List<TftUnit> units;

    @OneToMany
    private List<TftTrait> traits;

    protected TftParticipant() {

    }

    public TftParticipant(String name, int totalDamageToPlayers, int level, int goldLeft, List<TftUnit> units, List<TftTrait> traits) {
        this.name = name;
        this.totalDamageToPlayers = totalDamageToPlayers;
        this.level = level;
        this.goldLeft = goldLeft;
        this.units = units;
        this.traits = traits;
    }

    public String getName() {
        return name;
    }

    public int getTotalDamageToPlayers() {
        return totalDamageToPlayers;
    }

    public int getLevel() {
        return level;
    }

    public int getGoldLeft() {
        return goldLeft;
    }

    public List<TftUnit> getUnits() {
        return units;
    }

    public List<TftTrait> getTraits() {
        return traits;
    }
}
