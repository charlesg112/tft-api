package dybe.clan.tftapi.api;

import dybe.clan.tftapi.model.Summoner;

public interface TftSummonerAPI {
    Summoner getSummoner(String name, String server);
}
