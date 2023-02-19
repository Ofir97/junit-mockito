import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GoalStatisticsTest {

    @Mock GoalsService goalsService;
    @InjectMocks GoalStatistics goalStatistics;

    @Test
    void goalsPerGameTest() throws Exception {
        String playerName = "Steve";
        when(goalsService.getGoals(playerName)).thenReturn(100).thenReturn(10).thenReturn(0);

        assertEquals(10, goalStatistics.goalsPerGame(playerName, 10));
        assertEquals(1, goalStatistics.goalsPerGame(playerName, 10));
        assertThrows(Exception.class, () -> goalStatistics.goalsPerGame(playerName, 10));

        // final stubbed response will be used for subsequent calls to the method
    }

}