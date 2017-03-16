package com.javapp.stringswords.diamond;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiamondPrinter {
    public static final int A_INT = (int) 'A';

    /**
     * Creates spaces of length `length`
     * This creates blank spaces from the given length
     * @param length length of blank spaces to create
     * */
    private static String createBlanks(int length){
        return String.join("", Collections.nCopies(length, " "));
    }

    /**
     * Reverses a string
     * @param str The string to reverse
     * */
    private static String reverseString(String str){
        return new StringBuilder(str).reverse().toString();
    }

    /**
     * Takes a character and evaluates a diamond to print out.
     * The letter is cast to an integer and subtracted from the integer 'A' to get the number of rows
     * @param letter letter to print out a diamond
     * @return A list which will represent a diamond
     * */
    public List<String> printToList(char letter){
        // get the number of rows based on the character provided
        int nRows = 2 * ((int) letter -  A_INT) + 1;

        // this will store the top half of the rows in a list
        final List<String> topRows = new ArrayList<>();

        // we add 1 and divide by 2 because the rows will be odd, this will allow us to get an even
        // number to use to add characters to the topRow list
        for(int x = 0;x < (nRows + 1)/ 2; x++){
            // get the character from the provided addition
            char rowChar = (char) (A_INT + x);

            // get the right and left halves of the rows
            String leftHalfOfRow = createBlanks((nRows - 1 ) / 2 - x) + rowChar + createBlanks(x);

            // right half is created from the left half
            String rightHalfOfRow = reverseString(leftHalfOfRow.substring(0, leftHalfOfRow.length() - 1));

            // get the full row
            String fullRow = leftHalfOfRow + rightHalfOfRow;

            // finally add to list
            topRows.add(fullRow);
        }

        // now create the bottom half of the diamond
        for (int nRow = (nRows - 1) / 2 - 1; nRow >= 0; nRow--) {
            topRows.add(topRows.get(nRow));
        }

        return topRows;
    }

}
