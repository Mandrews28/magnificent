package mandrews.magnificent.service;

import mandrews.magnificent.dto.GameInputDTO;
import mandrews.magnificent.dto.InitialGameStateDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    public GameService() {}

    public InitialGameStateDTO createGame(GameInputDTO gameInput) {
        List<String> shuffledPlayers = Shuffle.playerOrder(gameInput.getPlayers());
        System.out.println(shuffledPlayers);
        return new InitialGameStateDTO(gameInput);
    }
}
