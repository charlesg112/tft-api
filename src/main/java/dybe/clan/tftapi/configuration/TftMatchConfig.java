package dybe.clan.tftapi.configuration;

import dybe.clan.tftapi.external.match.v1.TftMatchV1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TftMatchConfig {
    @Bean
    public TftMatchV1 getTftMatchV1() {
        return new TftMatchV1();
    }
}
