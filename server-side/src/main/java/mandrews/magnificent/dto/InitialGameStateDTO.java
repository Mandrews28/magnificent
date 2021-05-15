package mandrews.magnificent.dto;

import mandrews.magnificent.model.Chips;
import mandrews.magnificent.model.Development;
import mandrews.magnificent.model.Developments;
import mandrews.magnificent.model.Noble;

import java.util.List;

public class InitialGameStateDTO {

    private final List<String> playerOrder;
    private final Chips remainingChips;
    private final List<Noble> nobles;
    private final Developments developments;

    public InitialGameStateDTO(List<String> players, Chips remainingChips, List<Noble> nobles, Developments developments) {
        this.playerOrder = players;
        this.remainingChips = remainingChips;
        this.nobles = nobles;
        this.developments = developments;
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

    public Developments getDevelopments() {
        return developments;
    }
}
