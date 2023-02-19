package parameterized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class StudentScoreCalculatorTestParams {

    private static Stream<Arguments> provideScores() {
        return Stream.of(
                Arguments.of(20, 80, 1600),
                Arguments.of(-20, 80, -1),
                Arguments.of(150, 80, -1),
                Arguments.of(80, -20, -1),
                Arguments.of(80, 150, -1),
                Arguments.of(-20, -20, -1),
                Arguments.of(150, 150, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideScores")
    public void studentScoreCalculator(int mathsScore, int literacyScore, int expectedScore) {
        StudentScoreCalculator sc = new StudentScoreCalculator();
        sc.calculateSATScore(mathsScore, literacyScore);
        assertEquals(expectedScore, sc.getSatScore());
    }
}
