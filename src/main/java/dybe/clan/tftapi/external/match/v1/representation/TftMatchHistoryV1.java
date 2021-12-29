package dybe.clan.tftapi.external.match.v1.representation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TftMatchHistoryV1 {
    @Id @GeneratedValue
    private long id;

}
