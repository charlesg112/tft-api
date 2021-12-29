package dybe.clan.tftapi.api;

import dybe.clan.tftapi.model.TftMatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MatchResource {

    @Autowired
    public TftMatchAPI matchAPI;

    @GetMapping("/duos")
    public List<TftMatch> getDuos() {
        return matchAPI.getMatches("JeffHarrison", "TheHolyDrinker");
    }


}
