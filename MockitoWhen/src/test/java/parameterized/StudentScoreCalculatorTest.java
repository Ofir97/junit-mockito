package parameterized;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentScoreCalculatorTest {

    private StudentScoreCalculator sc;

    @BeforeEach
    void setUp() {
        sc = new StudentScoreCalculator();
    }

    @Test
    public void studentScoreCalculatorRegular() {
        sc.calculateSATScore(68, 80);

        assertEquals(5440, sc.getSatScore());
    }
}