import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    // expected values: values we expect the method to regularly receive and handle
    @Test
    public void squareIntegerHappyPath() {
        Calculator calculator = new Calculator();
        assertEquals(9, calculator.squareInteger(3));
        assertEquals(100, calculator.squareInteger(10));
    }

    // boundary values: values that are high/low as expected by the method
    @Test
    public void squaredIntegerUpperBoundary() {
        Calculator calculator = new Calculator();
        double sqrt = Math.sqrt(Integer.MAX_VALUE);
        assertThrows(IllegalArgumentException.class, () -> calculator.squareInteger((int) sqrt + 1));
    }

    @Test
    public void squaredIntegerLowerBoundary() {
        Calculator calculator = new Calculator();
        double sqrt = Math.sqrt(Integer.MIN_VALUE);
        assertThrows(IllegalArgumentException.class, () -> calculator.squareInteger((int) sqrt + 1));
    }

    // strange values: positive, negative, null..
    @Test
    public void squaredIntegerNull() {
        Calculator calculator = new Calculator();
        assertEquals(0, calculator.squareInteger(null));
    }

    @Test
    public void squaredIntegerNegative() {
        Calculator calculator = new Calculator();
        assertEquals(25, calculator.squareInteger(-5));
    }

}