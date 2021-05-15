package mandrews.magnificent.service;

import mandrews.magnificent.dto.GameInputDTO;
import mandrews.magnificent.dto.InitialGameStateDTO;
import mandrews.magnificent.model.Chips;
import mandrews.magnificent.model.Development;
import mandrews.magnificent.model.Noble;
import mandrews.magnificent.repository.DevelopmentRepository;
import mandrews.magnificent.repository.NobleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GameServiceTest {

    private static final String PLAYER_1 = "player1";
    private static final String PLAYER_2 = "player2";
    private static final String PLAYER_3 = "player3";
    private static final String PLAYER_4 = "player4";

    @Mock
    private DevelopmentRepository developmentRepository;

    @Mock
    private NobleRepository nobleRepository;

    private GameService gameService;

    private Iterable<Noble> nobles;
    private List<Development> level1Developments;
    private List<Development> level2Developments;
    private List<Development> level3Developments;

    @BeforeEach
    void setUpService() {
        gameService = new GameService(developmentRepository, nobleRepository);
        nobles = getMockedNobles();
        level1Developments = getMockedLevel1Developments();
        level2Developments = getMockedLevel2Developments();
        level3Developments = getMockedLevel3Developments();
    }

    @Test
    void given2PlayerRequest_whenCreateGame_thenGameIsReturnedSuccessfully() {
        List<String> players = Arrays.asList(PLAYER_1, PLAYER_2);
        GameInputDTO inputDTO = new GameInputDTO(players);

        when(nobleRepository.findAll()).thenReturn(nobles);
        when(developmentRepository.findByLevel(anyInt())).thenReturn(level1Developments, level2Developments, level3Developments);

        InitialGameStateDTO initialGameState = gameService.createGame(inputDTO);

        Chips chips = new Chips(4, 4, 4, 4, 4, 5);


        assertAll("Create 2 player game",
                () -> assertTrue(initialGameState.getPlayerOrder().contains(PLAYER_1)),
                () -> assertTrue(initialGameState.getPlayerOrder().contains(PLAYER_2)),
                () -> assertEquals(chips, initialGameState.getRemainingChips()),
                () -> assertEquals(3, initialGameState.getNobles().size()),
                () -> assertEquals(4, initialGameState.getDevelopments().getLevel1Developments().size()),
                () -> assertEquals(4, initialGameState.getDevelopments().getLevel2Developments().size()),
                () -> assertEquals(4, initialGameState.getDevelopments().getLevel3Developments().size()),
                () -> assertEquals(3, initialGameState.getDevelopments().getHiddenLevel1Developments().size()),
                () -> assertEquals(2, initialGameState.getDevelopments().getHiddenLevel2Developments().size()),
                () -> assertEquals(1, initialGameState.getDevelopments().getHiddenLevel3Developments().size())
        );
    }

    @Test
    void given3PlayerRequest_whenCreateGame_thenGameIsReturnedSuccessfully() {
        List<String> players = Arrays.asList(PLAYER_1, PLAYER_2, PLAYER_3);
        GameInputDTO inputDTO = new GameInputDTO(players);

        when(nobleRepository.findAll()).thenReturn(nobles);
        when(developmentRepository.findByLevel(anyInt())).thenReturn(level1Developments, level2Developments, level3Developments);

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
        List<String> players = Arrays.asList(PLAYER_1, PLAYER_2, PLAYER_3, PLAYER_4);
        GameInputDTO inputDTO = new GameInputDTO(players);

        when(nobleRepository.findAll()).thenReturn(nobles);
        when(developmentRepository.findByLevel(anyInt())).thenReturn(level1Developments, level2Developments, level3Developments);

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

    @Mock private Noble noble1;
    @Mock private Noble noble2;
    @Mock private Noble noble3;
    @Mock private Noble noble4;
    @Mock private Noble noble5;
    @Mock private Noble noble6;
    @Mock private Noble noble7;
    @Mock private Noble noble8;

    private List<Noble> getMockedNobles() {
        return Arrays.asList(noble1, noble2, noble3, noble4,
                noble5, noble6, noble7, noble8);
    }

    @Mock private Development development1;
    @Mock private Development development2;
    @Mock private Development development3;
    @Mock private Development development4;
    @Mock private Development development5;
    @Mock private Development development6;
    @Mock private Development development7;
    @Mock private Development development8;
    @Mock private Development development9;
    @Mock private Development development10;
    @Mock private Development development11;
    @Mock private Development development12;
    @Mock private Development development13;
    @Mock private Development development14;
    @Mock private Development development15;
    @Mock private Development development16;
    @Mock private Development development17;
    @Mock private Development development18;

    private List<Development> getMockedLevel1Developments() {
        return Arrays.asList(development1, development2, development3,
                development4, development5, development6, development7);
    }

    private List<Development> getMockedLevel2Developments() {
        return Arrays.asList(development8, development9, development10,
                development11, development12, development13);
    }

    private List<Development> getMockedLevel3Developments() {
        return Arrays.asList(development14, development15, development16,
                development17, development18);
    }
}
