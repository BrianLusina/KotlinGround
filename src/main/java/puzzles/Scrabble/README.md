
Write a program that, given a word, computes the scrabble score for that word.
Letter Values

You'll need these:

 1 Letter                           Value
 2 A, E, I, O, U, L, N, R, S, T       1
 3 D, G                               2
 4 B, C, M, P                         3
 5 F, H, V, W, Y                      4
 6 K                                  5
 7 J, X                               8
 8 Q, Z                               10


Examples

   "cabbage" should be scored as worth 14 points:

   3 points for C
   1 point for A, twice
   3 points for B, twice
   2 points for G
   1 point for E

   And to total:

   3 + 2*1 + 2*3 + 2 + 1
   = 3 + 2 + 6 + 3
   = 5 + 9
   = 14