package java.stringswords.RNATranscription;

import java.util.HashMap;

/**
 * Package: PACKAGE_NAME
 * Created by lusinabrian on 27/08/16 or 27 Aug of 2016,
 * Time: 11:09.
 * Project: java.java.stringswords.RNATranscription
 * Description:
 */
public class RnaTranscriptionV3 {
    private final static HashMap<Character, Character> lookup = new HashMap<>();

    static {
        lookup.put('G', 'C');
        lookup.put('C', 'G');
        lookup.put('T', 'A');
        lookup.put('A', 'U');
    }

    public static String ofDna(String dna) {
        StringBuilder builder = new StringBuilder();
        dna.chars().forEach(c -> builder.append(lookup.get((char) c)));
        return builder.toString();
    }
}

