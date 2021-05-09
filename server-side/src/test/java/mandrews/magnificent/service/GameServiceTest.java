package mandrews.magnificent.service;

import mandrews.magnificent.dto.GameInputDTO;
import mandrews.magnificent.dto.InitialGameStateDTO;
import mandrews.magnificent.model.Chips;
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

    private final GameService gameService = new GameService();

    @Test
    void given2PlayerRequest_whenCreateGame_thenGameIsReturnedSuccessfully() {
        List<String> players = new ArrayList<>();
        players.add(PLAYER_1);
        players.add(PLAYER_2);
        GameInputDTO inputDTO = new GameInputDTO(players);

        InitialGameStateDTO initialGameState = gameService.createGame(inputDTO);

        Chips chips = new Chips(4, 4, 4, 4, 4, 5);


        assertAll("Create 2 player game",
                () -> assertTrue(initialGameState.getPlayerOrder().contains(PLAYER_1)),
                () -> assertTrue(initialGameState.getPlayerOrder().contains(PLAYER_2)),
                () -> assertEquals(chips, initialGameState.getRemainingChips()),
                () -> assertEquals(3, initialGameState.getNobles().size())
        );
    }

    @Test
    void given3PlayerRequest_whenCreateGame_thenGameIsReturnedSuccessfully() {
        List<String> players = new ArrayList<>();
        players.add(PLAYER_1);
        players.add(PLAYER_2);
        players.add(PLAYER_3);
        GameInputDTO inputDTO = new GameInputDTO(players);

        InitialGameStateDTO initialGameState = gameService.createGame(inputDTO);

        Chips chips = new Chips(5, 5, 5, 5, 5, 5);

        assertAll("Create 3 player game",
                () -> assertTrue(initialGameState.getPlayerOrder().contains(PLAYER_1)),
                () -> assertTrue(initialGameState.getPlayerOrder().contains(PLAYER_2)),
                () -> assertTrue(initialGameState.getPlayerOrder().contains(PLAYER_3)),
                () -> assertEquals(chips, initialGameState.getRemainingChips()),
                () -> assertEquals(4, initialGameState.getNobles().size())
        );
    }

    @Test
    void given4PlayerRequest_whenCreateGame_thenGameIsReturnedSuccessfully() {
        List<String> players = new ArrayList<>();
        players.add(PLAYER_1);
        players.add(PLAYER_2);
        players.add(PLAYER_3);
        players.add(PLAYER_4);
        GameInputDTO inputDTO = new GameInputDTO(players);

        InitialGameStateDTO initialGameState = gameService.createGame(inputDTO);

        Chips chips = new Chips(7, 7, 7, 7, 7, 5);

        assertAll("Create 4 player game",
                () -> assertTrue(initialGameState.getPlayerOrder().contains(PLAYER_1)),
                () -> assertTrue(initialGameState.getPlayerOrder().contains(PLAYER_2)),
                () -> assertTrue(initialGameState.getPlayerOrder().contains(PLAYER_3)),
                () -> assertTrue(initialGameState.getPlayerOrder().contains(PLAYER_4)),
                () -> assertEquals(chips, initialGameState.getRemainingChips()),
                () -> assertEquals(5, initialGameState.getNobles().size())
        );
    }
}
