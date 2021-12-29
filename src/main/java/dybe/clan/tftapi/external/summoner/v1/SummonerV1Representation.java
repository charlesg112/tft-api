package dybe.clan.tftapi.external.summoner.v1;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SummonerV1Representation {
    @Id
    private String puuid;

    private String id;

    private String name;

    private int summonerLevel;

    private int profileIconId;

    public SummonerV1Representation(String puuid, String id, String name, int summonerLevel, int profileIconId) {
        this.puuid = puuid;
        this.id = id;
        this.name = name;
        this.summonerLevel = summonerLevel;
        this.profileIconId = profileIconId;
    }

    protected SummonerV1Representation() {

    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getSummonerLevel() {
        return this.summonerLevel;
    }

    public int profileIconId() {
        return this.profileIconId;
    }

    public String getPuuid() {
        return this.puuid;
    }

}
