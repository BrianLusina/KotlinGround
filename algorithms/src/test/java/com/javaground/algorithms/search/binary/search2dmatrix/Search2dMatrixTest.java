package com.javaground.algorithms.search.binary.search2dmatrix;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Search2dMatrixTest {
    public static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                {-7, -1, 5, 11},
                                {-6, 0, 6, 14},
                                {-4, 2, 9, 20}
                        },
                        6,
                        true
                ),
                Arguments.of(
                        new int[][]{
                                {-2, 0, 3},
                                {1, 4, 7},
                        },
                        -5,
                        false
                ),
                Arguments.of(
                        new int[][]{
                                {-10, -3},
                                {-4, 2},
                                {0, 5},
                        },
                        9,
                        false
                ),
                Arguments.of(
                        new int[][]{
                                {-13},
                        },
                        -13,
                        true
                )
        );
    }

    @ParameterizedTest(name = "{index} => search2dMatrix({0}, {1}) should return {2}")
    @MethodSource("testCases")
    @DisplayName("Search 2D Matrix II")
    void search2dMatrixII(int[][] matrix, int target, Boolean expected) {
        Boolean actual = Search2dMatrix.searchMatrixII(matrix, target);
        assertEquals(expected, actual);
    }
}