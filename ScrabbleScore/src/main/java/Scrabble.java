package ScrabbleScore.src.main.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Scrabble {
    private String input;

    /*constructor*/
    public Scrabble(String input){
        this.input = input;
    }
/*Letter                           Value
A, E, I, O, U, L, N, R, S, T       1
D, G                               2
B, C, M, P                         3
F, H, V, W, Y                      4
K                                  5
J, X                               8
Q, Z                               10*/
    /**Split the string into letters and loop through the letters against a hashmap
     * fill the hashmap with the letters and the scores.
     * iterate through input array checking if each letter is in a list
     * if so, add to the score
     * */
    public int getScore(){
        HashMap<List<String>, Integer> scrabbleScore = new HashMap<List<String>, Integer>();

        String[] stringArr = getInput().trim().split("");
        int score= 0;
        /*populate the hashmap*/
        scrabbleScore.put(Arrays.asList("a","e", "i", "o", "u", "l", "n", "r","s", "t"), 1);
        scrabbleScore.put(Arrays.asList("d","g"), 2);
        scrabbleScore.put(Arrays.asList("b","c", "m", "p"), 3);
        scrabbleScore.put(Arrays.asList("f","h", "v", "w", "y"), 4);
        scrabbleScore.put(Arrays.asList("k"), 5);
        scrabbleScore.put(Arrays.asList("j","x"), 8);
        scrabbleScore.put(Arrays.asList("q","z"), 10);

        /*iterate through keyset*/
        for(List<String> ls : scrabbleScore.keySet()){
            /*iterate through array*/
            for(String s: stringArr){
                /*if list contains the letter*/
                if(ls.contains(s)){
                    /*add to the final score*/
                   score += scrabbleScore.get(ls);
                }
            }
        }
        return score;
    }

    /*getters and setters*/
    public String getInput() {
        //perform null check, make the string empty
        if(input == null)
            input = "";
        return input.toLowerCase();
    }

    public void setInput(String input) {
        this.input = input;
    }
/*CLASS END*/
}
