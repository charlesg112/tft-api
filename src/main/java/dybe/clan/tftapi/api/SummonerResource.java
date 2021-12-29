package dybe.clan.tftapi.api;

import dybe.clan.tftapi.model.Summoner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SummonerResource {

    @Autowired
    private TftSummonerAPI summonerAPI;

    @GetMapping("/summoner/{name}")
    Summoner getSummoner(@PathVariable String name) {
        return summonerAPI.getSummoner(name, "NA");
    }

}
