package com.javaground.strings.anagram.countanagrams;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CountAnagramsTest {

    public static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("too hot", 18),
                Arguments.of("aa", 1),
                Arguments.of("all good", 36),
                Arguments.of("a a a b b", 1),
                Arguments.of("hello world", 7200),
                Arguments.of("excel", 60),
                Arguments.of("ab ab cd cd ef ef", 64)
        );
    }

    @ParameterizedTest(name = "{index} => CountAnagrams.of({0}) should return {1}")
    @MethodSource("testCases")
    void countAnagrams(String s, int expected) {
        int actual = CountAnagrams.of(s);
        assertEquals(expected, actual);
    }
}
