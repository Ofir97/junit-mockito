package before;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerStatisticsTest {
    
    private Player playerPatrickUnderThirty;
    private PlayerStatistics statisticsOfPatrickUnderThirty;

    @BeforeEach
    public void setUp() {
        playerPatrickUnderThirty = new Player("Patrick", 28);
        statisticsOfPatrickUnderThirty = new PlayerStatistics(playerPatrickUnderThirty, 20, 8);
    }

    @Test
    public void playerNamesEqual() {
        Player player2 = new Player("Patrick", 25);
        assertEquals(playerPatrickUnderThirty, player2);
    }

    @Test
    public void playerNamesNotEqual() {
        Player player2 = new Player("Sam", 25);
        assertNotEquals(playerPatrickUnderThirty, player2);
    }

    @Test
    public void youngerPlayerSame() {
        Player player2 = new Player("Sam", 25);
        assertSame(player2, PlayerStatistics.getYoungerPlayer(playerPatrickUnderThirty, player2));
    }

    @Test
    public void underThirtyTrue() {
        assertTrue(statisticsOfPatrickUnderThirty.underThirty());
    }

    @Test
    public void underThirtyFalse() {
        Player player = new Player("Patrick", 35);
        PlayerStatistics playerStatistics = new PlayerStatistics(player, 20, 20);
        assertFalse(playerStatistics.underThirty());
    }

    @Test
    public void csvReportNull() {
        Player player = new Player("Patrick", 35);
        PlayerStatistics playerStatistics = new PlayerStatistics(player, 0, 0);
        assertNull(playerStatistics.createCsvRecord());
    }

    @Test
    public void getCsvStateRecord() {
        Player player = new Player("Patrick", 35);
        PlayerStatistics playerStatistics = new PlayerStatistics(player, 8, 5);
        Double[] expectedCsvRecord = {0.625, 1.6};
        assertArrayEquals(expectedCsvRecord, playerStatistics.createCsvRecord());
    }
}
