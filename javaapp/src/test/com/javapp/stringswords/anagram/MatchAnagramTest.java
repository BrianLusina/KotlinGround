package com.javapp.stringswords.anagram;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class MatchAnagramTest {

    @Test
    public void testNoMatches() {
        MatchAnagram detector = new MatchAnagram("diaper");
        assertThat(detector.match(Arrays.asList("hello", "world", "zombies", "pants"))).isEmpty();
    }

    @Test
    public void testSimpleAnagram() {
        MatchAnagram detector = new MatchAnagram("ant");
        List<String> anagram = detector.match(Arrays.asList("tan", "stand", "at"));
        assertThat(anagram).containsExactly("tan");
    }

    @Test
    public void testDetectMultipleAnagrams() {
        MatchAnagram detector = new MatchAnagram("master");
        List<String> anagrams = detector.match(Arrays.asList("stream", "pigeon", "maters"));
        assertThat(anagrams).contains("maters", "stream");
    }

    @Test
    public void testDoesNotConfuseDifferentDuplicates() {
        MatchAnagram detector = new MatchAnagram("galea");
        List<String> anagrams = detector.match(Arrays.asList("eagle"));
        assertThat(anagrams).isEmpty();
    }

    @Test
    public void testIdenticalWordIsNotAnagram() {
        MatchAnagram detector = new MatchAnagram("corn");
        List<String> anagrams = detector.match(Arrays.asList("corn", "dark", "Corn", "rank", "CORN", "cron", "park"));
        assertThat(anagrams).containsExactly("cron");
    }

    @Test
    public void testEliminateAnagramsWithSameChecksum() {
        MatchAnagram detector = new MatchAnagram("mass");
        assertThat(detector.match(Arrays.asList("last")).isEmpty());
    }

    @Test
    public void testEliminateAnagramSubsets() {
        MatchAnagram detector = new MatchAnagram("good");
        assertThat(detector.match(Arrays.asList("dog", "goody"))).isEmpty();
    }

    @Test
    public void testDetectAnagrams() {
        MatchAnagram detector = new MatchAnagram("listen");
        List<String> anagrams = detector.match(Arrays.asList("enlists", "google", "inlets", "banana"));
        assertThat(anagrams).contains("inlets");
    }

    @Test
    public void testMultipleAnagrams() {
        MatchAnagram detector = new MatchAnagram("allergy");
        List<String> anagrams = detector.match(Arrays.asList("gallery", "ballerina", "regally", "clergy", "largely", "leading"));
        assertThat(anagrams).contains("gallery", "largely", "regally");
    }

    @Test
    public void testAnagramsAreCaseInsensitive() {
        MatchAnagram detector = new MatchAnagram("Orchestra");
        List<String> anagrams = detector.match(Arrays.asList("cashregister", "Carthorse", "radishes"));
        assertThat(anagrams).contains("Carthorse");
    }

}
