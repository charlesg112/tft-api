package dybe.clan.tftapi.external.match.v1;

import dybe.clan.tftapi.api.TftMatchAPI;
import dybe.clan.tftapi.api.TftSummonerAPI;
import dybe.clan.tftapi.external.LeagueAPIWebClient;
import dybe.clan.tftapi.external.match.v1.representation.TftMatchV1Representation;
import dybe.clan.tftapi.model.Summoner;
import dybe.clan.tftapi.model.TftMatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TftMatchV1 implements TftMatchAPI {

    @Autowired
    LeagueAPIWebClient leagueAPIWebClient;

    @Autowired
    TftMatchV1Assembler mapper;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    TftSummonerAPI summonerAPI;

    @Override
    public List<TftMatch> getMatches(String summoner1, String summoner2) {
        String firstSummonerId = getSummonerId(summoner1);
        String secondSummonerId = getSummonerId(summoner2);
        List<String> commonMatchesId = getCommonMatchesID(firstSummonerId, secondSummonerId);
        List<TftMatch> output = new ArrayList<>();
        for (String matchId : commonMatchesId) {
            ResponseEntity<TftMatchV1Representation> responseEntity = restTemplate.getForEntity(getMatchInfoUrl(matchId), TftMatchV1Representation.class);
            if (isDuoMatch(responseEntity.getBody())) {
                output.add(mapper.toMatch(summoner1, firstSummonerId, summoner2, secondSummonerId, responseEntity.getBody(), matchId));
            }
        }
        return output;
    }

    private List<String> getCommonMatchesID(String firstSummonerPuuid, String secondSummonerPuuid) {
        List<String> firstSummonerGames = getRecentMatchID(firstSummonerPuuid);
        List<String> secondSummonerGames = getRecentMatchID(secondSummonerPuuid);
        return firstSummonerGames.stream().filter(secondSummonerGames::contains).collect(Collectors.toList());
    }

    private String getSummonerId(String summonerName) {
        Summoner summoner = summonerAPI.getSummoner(summonerName, "NA");
        return summoner.getId();
    }

    private List<String> getRecentMatchID(String puuid) {
        ResponseEntity<String[]> responseEntity = restTemplate.getForEntity(getRecentMatchesUrl(puuid), String[].class);
        return Arrays.stream(responseEntity.getBody()).collect(Collectors.toList());
    }

    private String getRecentMatchesUrl(String puuid) {
        return String.format("https://americas.api.riotgames.com/tft/match/v1/matches/by-puuid/%s/ids?count=40&api_key=%s", puuid, leagueAPIWebClient.getApiKey());
    }

    private String getMatchInfoUrl(String matchId) {
        return String.format("https://americas.api.riotgames.com/tft/match/v1/matches/%s?api_key=%s", matchId, leagueAPIWebClient.getApiKey());
    }

    private boolean isDuoMatch(TftMatchV1Representation representation) {
        return representation.info.participants.get(0).getPartner_group_id().isPresent();
    }

}
