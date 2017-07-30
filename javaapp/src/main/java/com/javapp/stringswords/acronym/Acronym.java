package com.javapp.stringswords.acronym;

public class Acronym {

  public static String generate(String phrase) {
    String[] words = phrase.split("\\W+");
    String acro = "";
    for (String w : words) {
            /*add the first character and capitalize it*/
      acro += Character.toUpperCase(w.charAt(0));
      //obtain remaining letters
      String rem = w.substring(1, w.length());
      //check in remaining letters if there is a capital letter, add to acro
      for (String s : rem.split("")) {
        if (s.toUpperCase().equals(s)) {
          acro += s;
        }
      }
            /*replace all upper case letters and assign to upper remainder*/
      String upperRem = rem.replaceAll("^[A-Z]]", "");
            /*if not equal to empty or equal to remainder, add t0 acro*/
      if (!upperRem.equals("") && !upperRem.equals(rem)) {
        acro += upperRem;
      }
    }
    return acro;
  }

/*CLASS END*/
}
