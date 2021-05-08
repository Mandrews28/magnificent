package mandrews.magnificent.controller;

import com.google.gson.Gson;
import mandrews.magnificent.dto.GameInputDTO;
import mandrews.magnificent.dto.GameStateDTO;
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
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(GameController.class)
class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GameService gameService;

    @Test
    void givenRequestWithValidArguments_whenCreateGame_thenGameIsReturnedSuccessfully() throws Exception {
        List<String> players = new ArrayList<>();
        players.add("player1");
        players.add("player2");
        players.add("player3");
        GameInputDTO inputDTO = new GameInputDTO(players);

        when(gameService.createGame(any(GameInputDTO.class)))
                .thenReturn(new GameStateDTO(inputDTO));

        String json = new Gson().toJson(inputDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/game/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isCreated());

    }

}