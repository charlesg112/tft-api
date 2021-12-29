package dybe.clan.tftapi.api;

import dybe.clan.tftapi.model.TftMatch;

import java.util.List;

public interface TftMatchAPI {
    List<TftMatch> getMatches(String summoner1, String summoner2);
}
