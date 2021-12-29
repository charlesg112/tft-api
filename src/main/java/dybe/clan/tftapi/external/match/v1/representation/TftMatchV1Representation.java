package dybe.clan.tftapi.external.match.v1.representation;

import dybe.clan.tftapi.external.match.v1.representation.TftMatchInfoV1;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TftMatchV1Representation {
    @Id @GeneratedValue
    public String id;

    @Embedded
    public TftMatchInfoV1 info;
}
