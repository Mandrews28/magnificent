package mandrews.magnificent.service;

import mandrews.magnificent.dto.GameInputDTO;
import mandrews.magnificent.dto.GameStateDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    public GameService() {}

//    public GameStateDTO createGame(List<String> players) {
    public GameStateDTO createGame(GameInputDTO players) {
        return new GameStateDTO(players);
    }
}
