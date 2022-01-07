package dybe.clan.tftapi.api;

import dybe.clan.tftapi.model.TftMatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MatchResource {

    @Autowired
    public TftMatchAPI matchAPI;

    @GetMapping("/duos/{firstSummonerName}/{secondSummonerName}")
    public List<TftMatch> getDuos(@PathVariable String firstSummonerName, @PathVariable String secondSummonerName) {
        return matchAPI.getMatches(firstSummonerName, secondSummonerName);
    }

}
