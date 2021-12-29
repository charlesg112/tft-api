package dybe.clan.tftapi.external;

import org.springframework.stereotype.Service;

@Service
public class LeagueAPIWebClient {

    private final String API_KEY = System.getenv("riot_api_key");

    public String getApiKey() {
        return API_KEY;
    }

}
