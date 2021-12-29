package dybe.clan.tftapi.api.mappers;

import dybe.clan.tftapi.api.exceptions.SummonerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class SummonerNotFoundAdvice {

    private final String name = "SUMMONER_NOT_FOUND";
    private final String description = "Summoner could not be found on the specified server.";

    @ResponseBody
    @ExceptionHandler(SummonerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ExceptionBody summonerNotFoundHandler(SummonerNotFoundException e) {
        return new ExceptionBody(name, description);
    }
}
