package dybe.clan.tftapi.external.summoner.v1;

import dybe.clan.tftapi.model.Summoner;
import org.springframework.stereotype.Service;

@Service
public class SummonerV1Mapper {
    public Summoner toSummoner(SummonerV1Representation v1Representation, TftSummonerV1Representation tftInfo) {
        return new Summoner(v1Representation.getPuuid(), v1Representation.getName(), v1Representation.getSummonerLevel(), tftInfo.getTier(), tftInfo.getRank(), tftInfo.getWins(), tftInfo.getLosses());
    }
}
