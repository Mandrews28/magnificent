package mandrews.magnificent.service;

import mandrews.magnificent.dto.GameInputDTO;
import mandrews.magnificent.dto.InitialGameStateDTO;
import mandrews.magnificent.model.Chips;
import mandrews.magnificent.model.Development;
import mandrews.magnificent.model.Developments;
import mandrews.magnificent.model.Noble;
import mandrews.magnificent.repository.DevelopmentRepository;
import mandrews.magnificent.repository.NobleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class GameService {

    private static final int NUM_DEVELOPMENTS_SHOWN_PER_LEVEL = 4;

    private final DevelopmentRepository developmentRepository;
    private final NobleRepository nobleRepository;

    @Autowired
    public GameService(DevelopmentRepository developmentRepository, NobleRepository nobleRepository) {
        this.developmentRepository = developmentRepository;
        this.nobleRepository = nobleRepository;
    }

    public InitialGameStateDTO createGame(GameInputDTO gameInput) {
        List<String> players = gameInput.getPlayers();
        List<String> shuffledPlayers = Randomise.randomiseObjectOrder(players);
        System.out.println(shuffledPlayers);

        Chips remainingChips = getChipAllocation(players.size());

        List<Noble> nobles = getNobles(players.size() + 1);

        Developments developments = getDevelopments();

        return new InitialGameStateDTO(shuffledPlayers, remainingChips, nobles, developments);
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

    private List<Noble> getNobles(int num) {
        Iterable<Noble> nobleIterable = nobleRepository.findAll();
        List<Noble> nobles = StreamSupport
                .stream(nobleIterable.spliterator(), false)
                .collect(Collectors.toList());
        return Randomise.randomlyChooseSubset(nobles, num);
    }

    private Developments getDevelopments() {
        List<Development> allLevel1Developments = Randomise.randomiseObjectOrder(developmentRepository.findByLevel(1));
        List<Development> allLevel2Developments = Randomise.randomiseObjectOrder(developmentRepository.findByLevel(2));
        List<Development> allLevel3Developments = Randomise.randomiseObjectOrder(developmentRepository.findByLevel(3));

        List<Long> hiddenLevel1Developments = allLevel1Developments.stream()
                .skip(NUM_DEVELOPMENTS_SHOWN_PER_LEVEL)
                .map(Development::getId)
                .collect(Collectors.toList());

        List<Long> hiddenLevel2Developments = allLevel2Developments.stream()
                .skip(NUM_DEVELOPMENTS_SHOWN_PER_LEVEL)
                .map(Development::getId)
                .collect(Collectors.toList());

        List<Long> hiddenLevel3Developments = allLevel3Developments.stream()
                .skip(NUM_DEVELOPMENTS_SHOWN_PER_LEVEL)
                .map(Development::getId)
                .collect(Collectors.toList());

        return new Developments(allLevel1Developments.subList(0, 4), allLevel2Developments.subList(0, 4),
                allLevel3Developments.subList(0, 4), hiddenLevel1Developments, hiddenLevel2Developments, hiddenLevel3Developments);
    }
}
