import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CustomerOrderTest {

    @Spy BreakfastWaiter breakfastWaiter;
    @Spy DinnerWaiter dinnerWaiter;
    @InjectMocks CustomerOrder customerOrder;
    //@InjectMocks: scans for CustomerOrder fields, and automatically instantiates and assigns their @Spy/@Mock dependencies.

    @Test
    public void testServeVegetarianBreakfast() {
        List<String> expectedBreakfast = List.of("Apple", "Beans", "Hash brown", "Toast");
        assertEquals(expectedBreakfast, customerOrder.vegetarianBreakfast());
    }

    @Test
    public void testServeMeatBreakfast() {
        List<String> expectedMeatBreakfast = Arrays.asList("Apple", "Sausages", "Bacon", "Toast");
        assertEquals(expectedMeatBreakfast, customerOrder.meatBreakfast());
    }

    @Test
    public void testServeVegetarianDinner() {
        List<String> expectedDinner = Arrays.asList("Garlic bread", "Vegetable Lasagne", "Chocolate Brownie");
        assertEquals(expectedDinner, customerOrder.vegetarianDinner());
    }

    @Test
    public void testServeMeatDinner() {
        List<String> expectedDinner = Arrays.asList("Calamari", "Roast Chicken", "Sticky toffee pudding");
        assertEquals(expectedDinner, customerOrder.meatDinner());
    }
}
