package custommatcher;

import org.assertj.core.api.AbstractAssert;
import statistics.Player;

public class PlayerAssert extends AbstractAssert<PlayerAssert, Player> {

    // create a static method to return PlayerAssert
    public static PlayerAssert assertThat(Player player) {
        return new PlayerAssert(player);
    }

    protected PlayerAssert(Player player) {
        super(player, PlayerAssert.class);
    }

    // create custom matcher method that returns PlayerAssert
    public PlayerAssert hasName(String expectedName) {
        isNotNull();

        // actual: represents the actual object instance being tested upon
        if (!actual.getName().equals(expectedName)) {
            failWithMessage("Expected name: " + expectedName + ", but was: " + actual.getName());
        }

        return this;

    }
}
