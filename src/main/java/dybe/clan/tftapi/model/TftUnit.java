package dybe.clan.tftapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TftUnit {
    public String name;

    public int rarity;

    public int tier;

    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    protected TftUnit() {}

    public  TftUnit(String name, int rarity, int tier) {
        this.name = name;
        this.rarity = rarity;
        this.tier = tier;
    }
}
