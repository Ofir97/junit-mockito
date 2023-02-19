package statistics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
        assertThat(player2).isEqualTo(playerPatrickUnderThirty);
        // first item: actual object, second item: expected object
    }

    @Test
    public void playerNamesNotEqual() {
        Player player2 = new Player("Sam", 25);
        assertThat(player2).isNotEqualTo(playerPatrickUnderThirty);
    }

    @Test
    public void youngerPlayerSame() {
        Player player2 = new Player("Sam", 25);
        assertThat(PlayerStatistics.getYoungerPlayer(playerPatrickUnderThirty, player2)).isSameAs(player2);
    }

    @Test
    public void underThirtyTrue() {
        assertThat(statisticsOfPatrickUnderThirty.underThirty()).isTrue();
    }

    @Test
    public void underThirtyFalse() {
        Player player = new Player("Patrick", 35);
        PlayerStatistics playerStatistics = new PlayerStatistics(player, 20, 20);
        assertThat(playerStatistics.underThirty()).isFalse();
    }

    @Test
    public void csvReportNull() {
        Player player = new Player("Patrick", 35);
        PlayerStatistics playerStatistics = new PlayerStatistics(player, 0, 0);
        assertThat(playerStatistics.createCsvRecord()).isNull();
    }

    @Test
    public void getCsvStateRecord() {
        Player player = new Player("Patrick", 35);
        PlayerStatistics playerStatistics = new PlayerStatistics(player, 8, 5);
        Double[] expectedCsvRecord = {0.625, 1.6};
        assertThat(playerStatistics.createCsvRecord()).isEqualTo(expectedCsvRecord);
    }
}
