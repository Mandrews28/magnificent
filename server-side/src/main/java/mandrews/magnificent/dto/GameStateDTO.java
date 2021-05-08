package mandrews.magnificent.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GameStateDTO {

    private final List<String> players;

    @JsonCreator
    public GameStateDTO(@JsonProperty(value = "state", required = true) GameInputDTO input) {
        this.players = input.getPlayers();
    }

    public List<String> getPlayers() {
        return players;
    }
}
