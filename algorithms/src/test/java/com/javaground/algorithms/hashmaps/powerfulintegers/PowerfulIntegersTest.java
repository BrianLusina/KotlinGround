package com.javaground.algorithms.hashmaps.powerfulintegers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PowerfulIntegersTest {
    public static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(2, 2, 20, List.of(2, 3, 4, 5, 6, 8, 9, 10, 12, 16, 17, 18, 20)),
                Arguments.of(1, 1, 5, List.of(2)),
                Arguments.of(5, 3, 50, List.of(2, 4, 6, 8, 10, 14, 26, 28, 32, 34)),
                Arguments.of(100, 100, 1000000, List.of(2, 101, 200, 10001, 10100, 20000)),
                Arguments.of(2, 5, 0, List.of()),
                Arguments.of(2, 3, 10, List.of(2, 3, 4, 5, 7, 9, 10)),
                Arguments.of(3, 5, 15, List.of(2, 4, 6, 8, 10, 14))
        );
    }

    @ParameterizedTest(name = "{index} => powerfulIntegers({0}, {1}, {2}) should return {3}")
    @MethodSource("testCases")
    @DisplayName("Powerful integers logarithmic bounds 2")
    void powerFulIntegers(int x, int y, int bound, List<Integer> expected) {
        List<Integer> actual = PowerfulIntegers.of(x, y, bound);
        actual.sort(Integer::compareTo);
        assertEquals(expected, actual);
    }

    @ParameterizedTest(name = "{index} => powerfulIntegersLogarithmicBounds({0}, {1}, {2}) should return {3}")
    @MethodSource("testCases")
    @DisplayName("Powerful integers logarithmic bounds")
    void powerFulIntegersLogarithmicBounds(int x, int y, int bound, List<Integer> expected) {
        List<Integer> actual = PowerfulIntegers.logarithmicBounds(x, y, bound);
        actual.sort(Integer::compareTo);
        assertEquals(expected, actual);
    }
}
