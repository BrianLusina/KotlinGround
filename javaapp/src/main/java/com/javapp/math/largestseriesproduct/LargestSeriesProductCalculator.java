package com.javapp.math.largestseriesproduct;


public class LargestSeriesProductCalculator {
    private String series;

    public LargestSeriesProductCalculator(String series){
        this.series = series;
        validateStringInput();
    }

    /**
     * Calculates the largest product in the given series string
     * First starts by validating the length input, if the input length is less than 0, i.e. negative
     * an {@link IllegalArgumentException} is thrown. if the length input is greater than the length of
     * the series input, an {@link IllegalArgumentException} is also thrown.
     * if the length is 0, then the function returns 1
     * @throws IllegalArgumentException in the event the length of the input is invalid
     * @param length the length to check for the largest product in the given string*/
    public long calculateLargestProductForSeriesLength(int length){
        if(length < 0) {
            throw new IllegalArgumentException("Series length must be non-negative.");
        }else if(length > series.length()){
            throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");
        }else if(length == 0){
            return 1;
        }else{
            long result = 0;
            int numberOfSeriesToCheck = series.length() - length + 1;
            for(int startIndex = 0; startIndex < numberOfSeriesToCheck; startIndex++){
                /*
                 * todo: look for a more efficient solution
                 * Not the most efficient solution, but simplest to reason about
                 * */
                result = Math.max(result, computeProductOfSeries(startIndex, length));
            }
            return result;
        }
    }

    /**
     * Validates the string series input
     * Checks for null inputs and whether the string input contains only character inputs
     * @throws IllegalArgumentException if the series string is null or one of the characters is not
     * a digit
     * */
    private void validateStringInput() throws IllegalArgumentException{
        if(series == null){
            throw new IllegalArgumentException("String to search must be non-null.");
        }else if(!series.chars().allMatch(Character::isDigit)){
            throw new IllegalArgumentException("String to search may only contains digits.");
        }
    }

    /**
     * Computes the product for the current series
     * @param startIndex the start index of the computation
     * @param length the length of the series to check through
     * */
    private long computeProductOfSeries(final int startIndex, final int length){
        long result = 1;
        int endIndex = startIndex + length - 1;

        for(int charIndex = startIndex; charIndex <= endIndex; charIndex++){
            result *= Character.getNumericValue(series.charAt(charIndex));
        }
        return result;
    }
}
