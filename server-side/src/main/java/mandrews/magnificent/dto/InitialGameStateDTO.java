package mandrews.magnificent.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class InitialGameStateDTO {

    private final List<String> playerOrder;

//    @JsonCreator
//    public InitialGameStateDTO(@JsonProperty(value = "state", required = true) GameInputDTO input) {
    public InitialGameStateDTO(GameInputDTO input) {
        this.playerOrder = input.getPlayers();
    }

    public List<String> getPlayerOrder() {
        return playerOrder;
    }
}

///// initial game state
// available chips - dependent on players
// available nobles
// available lvl1/2/3 developments (3 objs)
// hidden developments - dev ids only