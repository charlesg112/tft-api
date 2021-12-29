package dybe.clan.tftapi.external.summoner.v1;

import dybe.clan.tftapi.api.TftSummonerAPI;
import dybe.clan.tftapi.api.exceptions.SummonerNotFoundException;
import dybe.clan.tftapi.external.LeagueAPIWebClient;
import dybe.clan.tftapi.model.Summoner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class TftSummonerV1 implements TftSummonerAPI {

    @Autowired
    private LeagueAPIWebClient leagueAPIWebClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private SummonerV1Mapper mapper;

    @Override
    public Summoner getSummoner(String name, String server) {
        try {
            String url = getSummonerUrl(name);
            ResponseEntity<SummonerV1Representation> responseEntity = restTemplate.getForEntity(url, SummonerV1Representation.class);
            SummonerV1Representation representation = responseEntity.getBody();
            if  (representation == null) throw new SummonerNotFoundException();
            TftSummonerV1Representation tftInfo = getTftRepresentation(representation.getId());
            return mapper.toSummoner(representation, tftInfo);

        } catch (Exception e) {
            throw new SummonerNotFoundException();
        }
    }

    private TftSummonerV1Representation getTftRepresentation(String summonerId) {
        try {
            String url = getTftSummonerUrl(summonerId);
            ResponseEntity<TftSummonerV1Representation[]> responseEntity = restTemplate.getForEntity(url, TftSummonerV1Representation[].class);
            TftSummonerV1Representation representation = responseEntity.getBody()[0];
            if  (representation == null) throw new SummonerNotFoundException();
            return representation;

        } catch (Exception e) {
            throw new SummonerNotFoundException();
        }
    }

    private String getSummonerUrl(String name) {
        return String.format("https://na1.api.riotgames.com/tft/summoner/v1/summoners/by-name/%s?api_key=%s", name, leagueAPIWebClient.getApiKey());
    }

    private String getTftSummonerUrl(String summonerId) {
        return String.format("https://na1.api.riotgames.com/tft/league/v1/entries/by-summoner/%s?api_key=%s", summonerId, leagueAPIWebClient.getApiKey());
    }

}
