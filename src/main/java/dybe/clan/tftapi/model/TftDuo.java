package dybe.clan.tftapi.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TftDuo {
    @Id
    @GeneratedValue
    private int id;

    public int placement;

    @OneToMany
    public List<TftParticipant> participants;

    public TftDuo() {
        participants = new ArrayList<>();
    }
}
