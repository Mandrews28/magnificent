package mandrews.magnificent.controller;

import com.google.gson.Gson;
import mandrews.magnificent.dto.GameInputDTO;
import mandrews.magnificent.dto.InitialGameStateDTO;
import mandrews.magnificent.model.Chips;
import mandrews.magnificent.model.Developments;
import mandrews.magnificent.service.GameService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(SpringExtension.class)
@WebMvcTest(GameController.class)
class GameControllerTest {

    private static final String PLAYER_1 = "player1";
    private static final String PLAYER_2 = "player2";
    private static final String PLAYER_3 = "player3";
    private static final String PLAYER_4 = "player4";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GameService gameService;

    @Test
    void given3PlayerRequest_whenCreateGame_thenGameIsReturnedSuccessfully() throws Exception {
        List<String> players = Arrays.asList(PLAYER_1, PLAYER_2, PLAYER_3);
        GameInputDTO inputDTO = new GameInputDTO(players);

        when(gameService.createGame(any(GameInputDTO.class)))
                .thenReturn(new InitialGameStateDTO(players,
                        new Chips(), new ArrayList<>(),
                        new Developments(
                                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                                new ArrayList<>(), new ArrayList<>(), new ArrayList<>())
                ));

        String json = new Gson().toJson(inputDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/game/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(jsonPath("playerOrder[0]").value(PLAYER_1))
                .andExpect(jsonPath("playerOrder[1]").value(PLAYER_2))
                .andExpect(jsonPath("playerOrder[2]").value(PLAYER_3))
                .andExpect(jsonPath("remainingChips").exists())
                .andExpect(jsonPath("nobles").exists())
                .andExpect(jsonPath("developments.level1Developments").exists())
                .andExpect(jsonPath("developments.level2Developments").exists())
                .andExpect(jsonPath("developments.level3Developments").exists())
                .andExpect(jsonPath("developments.hiddenLevel1Developments").exists())
                .andExpect(jsonPath("developments.hiddenLevel2Developments").exists())
                .andExpect(jsonPath("developments.hiddenLevel3Developments").exists())
        ;

    }

}