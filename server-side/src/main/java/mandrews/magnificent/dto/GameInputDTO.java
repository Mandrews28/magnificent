package mandrews.magnificent.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GameInputDTO {
    private final List<String> players;

    @JsonCreator
    public GameInputDTO(
            @JsonProperty(value = "players", required = true) List<String> players) {
        this.players = players;
    }

    public List<String> getPlayers() {
        return players;
    }
}
