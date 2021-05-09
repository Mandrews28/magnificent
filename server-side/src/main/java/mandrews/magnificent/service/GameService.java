package mandrews.magnificent.service;

import mandrews.magnificent.dto.GameInputDTO;
import mandrews.magnificent.dto.InitialGameStateDTO;
import mandrews.magnificent.model.Chips;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    public GameService() {
    }

    public InitialGameStateDTO createGame(GameInputDTO gameInput) {
        List<String> players = gameInput.getPlayers();
        List<String> shuffledPlayers = Shuffle.playerOrder(players);
        System.out.println(shuffledPlayers);

        Chips remainingChips = getChipAllocation(players.size());

        //TODO: add noble repository


        return new InitialGameStateDTO(shuffledPlayers, remainingChips);
    }

    private Chips getChipAllocation(int numberOfPlayers) {
        Chips chips;
        switch (numberOfPlayers) {
            case 2:
                chips = new Chips(4, 4, 4, 4, 4, 5);
                break;
            case 3:
                chips = new Chips(5, 5, 5, 5, 5, 5);
                break;
            case 4:
            default:
                chips = new Chips(7, 7, 7, 7, 7, 5);
        }
        return chips;
    }
}
