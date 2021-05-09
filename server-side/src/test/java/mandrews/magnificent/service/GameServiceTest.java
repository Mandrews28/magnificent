package mandrews.magnificent.service;

import mandrews.magnificent.dto.GameInputDTO;
import mandrews.magnificent.dto.InitialGameStateDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class GameServiceTest {

    private static final String PLAYER_1 = "player1";
    private static final String PLAYER_2 = "player2";
    private static final String PLAYER_3 = "player3";
    private static final String PLAYER_4 = "player4";

    private GameService gameService = new GameService();

    @Test
    void given3PlayerRequest_whenCreateGame_thenGameIsReturnedSuccessfully() throws Exception {
        List<String> players = new ArrayList<>();
        players.add(PLAYER_1);
        players.add(PLAYER_2);
        players.add(PLAYER_3);
        GameInputDTO inputDTO = new GameInputDTO(players);

        InitialGameStateDTO initialGameState = gameService.createGame(inputDTO);

        assertAll("Create 3 player game",
                () -> assertTrue(initialGameState.getPlayerOrder().contains(PLAYER_1)),
                () -> assertTrue(initialGameState.getPlayerOrder().contains(PLAYER_2)),
                () -> assertTrue(initialGameState.getPlayerOrder().contains(PLAYER_3)));
    }
}
