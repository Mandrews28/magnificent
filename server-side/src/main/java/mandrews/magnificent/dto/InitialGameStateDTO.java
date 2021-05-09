package mandrews.magnificent.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import mandrews.magnificent.model.Chips;
import mandrews.magnificent.model.Noble;

import java.util.ArrayList;
import java.util.List;

public class InitialGameStateDTO {

    private final List<String> playerOrder;
    private final Chips remainingChips;
    private final List<Noble> nobles;

//    @JsonCreator
//    public InitialGameStateDTO(@JsonProperty(value = "state", required = true) GameInputDTO input) {
    public InitialGameStateDTO(List<String> players, Chips remainingChips) {
        this.playerOrder = players;
        this.remainingChips = remainingChips;
        this.nobles = new ArrayList<>();
    }

    public List<String> getPlayerOrder() {
        return playerOrder;
    }

    public Chips getRemainingChips() {
        return remainingChips;
    }

    public List<Noble> getNobles() {
        return nobles;
    }
}

///// initial game state
// available nobles
// available lvl1/2/3 developments (3 objs)
// hidden developments - dev ids only