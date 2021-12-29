package dybe.clan.tftapi.external.match.v1.representation;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TftTraitsV1 {
    @Id
    private String name;

    private int num_units;

    private int tier_total;

    private int style;

    public String getName() {
        return name;
    }

    public int getNum_units() {
        return num_units;
    }

    public int getTier_total() {
        return tier_total;
    }

    public int getStyle() {
        return style;
    }

    protected TftTraitsV1() {}

}
