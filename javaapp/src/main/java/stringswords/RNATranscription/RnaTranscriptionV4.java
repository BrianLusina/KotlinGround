package main.stringswords.RNATranscription;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Package: PACKAGE_NAME
 * Created by lusinabrian on 27/08/16 or 27 Aug of 2016,
 * Time: 11:14.
 * Project: java.java.stringswords.RNATranscription
 * Description:
 */
public class RnaTranscriptionV4 {
    public static String ofDna(String input) {
        Map<Character, Character> dnarnaMap = new HashMap<>();
        dnarnaMap.put('G', 'C');
        dnarnaMap.put('C', 'G');
        dnarnaMap.put('T', 'A');
        dnarnaMap.put('A', 'U');

        return input.chars().mapToObj(c -> (char) c)
                .map(n -> dnarnaMap.get(n).toString())
                .collect(Collectors.joining());
    }
}
