package dybe.clan.tftapi.external.match.v1.representation;

import javax.persistence.*;
import java.util.List;

@Entity
public class TftParticipantV1 {
    @Id
    private String puuid;

    private int level;

    private int partner_group_id;

    private int total_damage_to_players;

    private int gold_left;

    private int placement;

    @OneToMany
    private List<TftTraitsV1> traits;

    @OneToMany
    private List<TftUnitV1> units;

    public TftParticipantV1() {}

    public String getPuuid() {
        return this.puuid;
    }

    public int getLevel() {
        return level;
    }

    public int getPartner_group_id() {
        return partner_group_id;
    }

    public List<TftTraitsV1> getTraits() {
        return traits;
    }

    public List<TftUnitV1> getUnits() {
        return units;
    }

    public int getTotal_damage_to_players() {
        return total_damage_to_players;
    }

    public int getGold_left() {
        return gold_left;
    }

    public int getPlacement() {
        return placement;
    }
}
