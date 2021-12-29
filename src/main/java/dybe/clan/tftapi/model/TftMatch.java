package dybe.clan.tftapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class TftMatch {
    @Id
    private String matchId;

    @OneToMany
    private List<TftDuo> duos;


    public TftMatch(String matchId, List<TftDuo> duos) {
        this.matchId = matchId;
        this.duos = duos;
    }

    public String getMatchId() {
        return this.matchId;
    }

    public List<TftDuo> getDuos() {
        return duos;
    }

    protected TftMatch() {

    }

}
