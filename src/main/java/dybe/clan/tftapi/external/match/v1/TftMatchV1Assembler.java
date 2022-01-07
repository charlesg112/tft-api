package dybe.clan.tftapi.external.match.v1;

import dybe.clan.tftapi.external.match.v1.representation.TftMatchV1Representation;
import dybe.clan.tftapi.external.match.v1.representation.TftParticipantV1;
import dybe.clan.tftapi.external.match.v1.representation.TftTraitsV1;
import dybe.clan.tftapi.external.match.v1.representation.TftUnitV1;
import dybe.clan.tftapi.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TftMatchV1Assembler {
    public TftMatch toMatch(String summoner1, String summoner1Id, String summoner2, String summoner2Id, TftMatchV1Representation representation, String matchId) {
        List<TftDuo> duos = new ArrayList<>();

        for (int i = 0; i< representation.info.participants.size() / 2; ++i) {
            duos.add(new TftDuo());
        }

        for (TftParticipantV1 participant : representation.info.participants) {
            TftDuo duo = duos.get(participant.getPartner_group_id().get() - 1);
            List<TftUnit> units = participant.getUnits().stream().map(this::toTftUnit).collect(Collectors.toList());
            List<TftTrait> traits = participant.getTraits().stream().map(this::toTftTrait).collect(Collectors.toList());
            String name = getName(participant, summoner1Id, summoner1, summoner2Id, summoner2);
            duo.placement = participant.getPlacement() / 2;

            duo.participants.add(new TftParticipant(name, participant.getTotal_damage_to_players(), participant.getLevel(), participant.getGold_left(), units, traits));
        }

        return new TftMatch(matchId, duos, representation.info.getGame_datetime());
    }

    private TftUnit toTftUnit(TftUnitV1 tftUnitV1) {
        return new TftUnit(tftUnitV1.getCharacter_id(), tftUnitV1.getRarity(), tftUnitV1.getTier());
    }

    private TftTrait toTftTrait(TftTraitsV1 tftTraitsV1) {
        return new TftTrait(tftTraitsV1.getName(), tftTraitsV1.getNum_units(), tftTraitsV1.getTier_total(), tftTraitsV1.getStyle());
    }

    private String getName(TftParticipantV1 participant, String summoner1Id, String summoner1Name, String summoner2Id, String summoner2Name) {
        if (participant.getPuuid().equals(summoner1Id)) return summoner1Name;
        else if (participant.getPuuid().equals(summoner2Id)) return summoner2Name;
        return participant.getPuuid();
    }
}
