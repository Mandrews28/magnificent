package mandrews.magnificent.repository;

import mandrews.magnificent.model.Chip;
import mandrews.magnificent.model.Development;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class DevelopmentRepositoryTest {

    private static final int LEVEL_1 = 1;

    @Autowired
    private DevelopmentRepository developmentRepository;

    @Test
    void givenDevelopmentsInDB_whenFindLevel1Developments_thenReturnListSuccessfully() {
        List<Development> developments = developmentRepository.findByLevel(LEVEL_1);

        assertEquals(40, developments.size());
    }

    @Test
    void givenDevelopmentsInDBAndALocalDevelopment_whenFindDevelopments_thenObjectsAreNotEqual() {
        Development localDevelopment = new Development(LEVEL_1, Chip.BLUE, 1, 0, 0, 0, 4, 0);

        List<Development> savedDevelopments = developmentRepository.findByLevel(LEVEL_1);

        List<Development> filteredDevelopment = savedDevelopments.stream()
                .filter(development -> development.getInfluencePoints() == 1)
                .filter(development -> development.getRewardChipColour().equals(Chip.BLUE))
                .collect(Collectors.toList());

        assertNotEquals(localDevelopment, filteredDevelopment.get(0));
    }
}
