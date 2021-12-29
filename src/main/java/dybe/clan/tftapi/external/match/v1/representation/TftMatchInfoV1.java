package dybe.clan.tftapi.external.match.v1.representation;


import javax.persistence.*;
import java.util.List;

@Embeddable
public class TftMatchInfoV1 {
    @OneToMany
    public List<TftParticipantV1> participants;

    public List<TftParticipantV1> getParticipants() {
        return this.participants;
    }
}
