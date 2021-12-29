package dybe.clan.tftapi.external.summoner.v1;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TftSummonerV1Representation {
    @Id
    private String summonerId;

    private String tier;

    private String rank;

    private int leaguePoints;

    private int wins;

    private int losses;

    public String getTier() {
        return tier;
    }

    public String getRank() {
        return rank;
    }

    public int getLeaguePoints() {
        return leaguePoints;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public String getSummonerId() {
        return summonerId;
    }

}
