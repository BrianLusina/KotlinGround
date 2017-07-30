package com.javapp.stringswords.RNATranscription;

public class RnaTranscription {

  public static String ofDna(String DNA) {
    String RNA = "";
    for (char nucleotide : DNA.toCharArray()) {
      if (nucleotide == 'G') {
        RNA += 'C';
      }
      if (nucleotide == 'C') {
        RNA += 'G';
      }
      if (nucleotide == 'T') {
        RNA += 'A';
      }
      if (nucleotide == 'A') {
        RNA += 'U';
      }
    }
    return RNA;
  }
}
