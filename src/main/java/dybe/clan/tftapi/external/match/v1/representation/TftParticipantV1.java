package dybe.clan.tftapi.external.match.v1.representation;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
public class TftParticipantV1 {
    @Id
    private String puuid;

    private int level;

    @Column(nullable = true)
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

    public Optional<Integer> getPartner_group_id() {
        return Optional.ofNullable(partner_group_id);
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
