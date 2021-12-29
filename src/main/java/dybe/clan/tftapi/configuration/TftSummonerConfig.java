package dybe.clan.tftapi.configuration;

import dybe.clan.tftapi.external.summoner.v1.TftSummonerV1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TftSummonerConfig {
    @Bean
    public TftSummonerV1 getTftSummonerV1() {
        return new TftSummonerV1();
    }
}
