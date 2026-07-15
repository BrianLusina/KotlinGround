package com.javaground.algorithms.trie.indexpairs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class IndexPairsTest {

    public static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(
                        "thestoryofeducativeandme",
                        new String[]{"story", "feduc", "educative"},
                        new int[][]{{3, 7}, {9, 13}, {10, 18}}
                ),
                Arguments.of(
                        "xyxyx",
                        new String[]{"xyx", "xy"},
                        new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}}
                ),
                Arguments.of(
                        "howareyou",
                        new String[]{"how", "are", "you"},
                        new int[][]{{0, 2}, {3, 5}, {6, 8}}
                ),
                Arguments.of(
                        "weather",
                        new String[]{"weather"},
                        new int[][]{{0, 6}}
                ),
                Arguments.of(
                        "aquickbrownfoxjumpsoverthelazydog",
                        new String[]{"quick", "fox", "dog"},
                        new int[][]{{1, 5},{11, 13}, {30, 32}}
                )
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void indexPairs(String text, String[] words, int[][] expected) {
        int[][] actual = IndexPairs.of(text, words);
        assertArrayEquals(expected, actual);
    }
}
