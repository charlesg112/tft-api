package dybe.clan.tftapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TftTrait {
    @Id
    private String name;

    private int numUnits;

    private int tierTotal;

    private int style;

    public TftTrait(String name, int numUnits, int tierTotal, int style) {
        this.name = name;
        this.numUnits = numUnits;
        this.tierTotal = tierTotal;
        this.style = style;
    }

    public String getName() {
        return name;
    }

    public int getNumUnits() {
        return numUnits;
    }

    public int getTierTotal() {
        return tierTotal;
    }

    protected TftTrait() {}

    public int getStyle() {
        return style;
    }
}