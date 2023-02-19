import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CarShopTest {

    @Test
    public void testCarsInShop_UsingThenReturn() {
        CarShop carShop = spy(CarShop.class);
        Map<String, Integer> carsInStock = new HashMap<>();
        carsInStock.put("Jaguar", 10);
        carsInStock.put("Mazda", 5);

        when(carShop.getCarsInStock()).thenReturn(carsInStock); // calls getCarsInStock()
        assertEquals(5, carShop.getStockForBrand("Mazda"));
    }

    @Test
    public void testCarsInShop_UsingDoReturn() {
        CarShop carShop = spy(CarShop.class);
        Map<String, Integer> carsInStock = new HashMap<>();
        carsInStock.put("Jaguar", 10);
        carsInStock.put("Mazda", 5);

        doReturn(carsInStock).when(carShop).getCarsInStock(); // does NOT call getCarsInStock()
        assertEquals(5, carShop.getStockForBrand("Mazda"));
    }
}