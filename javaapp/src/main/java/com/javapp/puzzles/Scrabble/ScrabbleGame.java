package com.javapp.puzzles.Scrabble;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ScrabbleGame {

  private String input;

  /*constructor*/
  public ScrabbleGame(String input) {
    this.input = input;
  }

  public int getScore() {
    HashMap<List<String>, Integer> scrabbleScore = new HashMap<List<String>, Integer>();

    String[] stringArr = getInput().trim().split("");
    int score = 0;
        /*populate the hashmap*/
    scrabbleScore.put(Arrays.asList("a", "e", "i", "o", "u", "l", "n", "r", "s", "t"), 1);
    scrabbleScore.put(Arrays.asList("d", "g"), 2);
    scrabbleScore.put(Arrays.asList("b", "c", "m", "p"), 3);
    scrabbleScore.put(Arrays.asList("f", "h", "v", "w", "y"), 4);
    scrabbleScore.put(Arrays.asList("k"), 5);
    scrabbleScore.put(Arrays.asList("j", "x"), 8);
    scrabbleScore.put(Arrays.asList("q", "z"), 10);

        /*iterate through keyset*/
    for (List<String> ls : scrabbleScore.keySet()) {
            /*iterate through array*/
      for (String s : stringArr) {
                /*if list contains the letter*/
        if (ls.contains(s)) {
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
    if (input == null) {
      input = "";
    }
    return input.toLowerCase();
  }

  public void setInput(String input) {
    this.input = input;
  }
}