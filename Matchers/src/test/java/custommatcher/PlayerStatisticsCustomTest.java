package custommatcher;

import org.junit.jupiter.api.Test;
import statistics.Player;

public class PlayerStatisticsCustomTest {

    @Test
    public void playerConstructorAssignsName() {
        Player player = new Player("Bill", 34);
        PlayerAssert.assertThat(player).hasName("Bill");
    }
}
