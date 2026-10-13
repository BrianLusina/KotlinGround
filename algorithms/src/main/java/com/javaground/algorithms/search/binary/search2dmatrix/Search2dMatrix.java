package com.javaground.algorithms.search.binary.search2dmatrix;

public class Search2dMatrix {
    /**
     * Searches for a target value in a 2D matrix.
     * Each row in the matrix is searched using binary search template.
     *
     * @param matrix The 2D integer matrix to search in
     * @param target The target value to find
     * @return true if the target is found, false otherwise
     */
    public static boolean searchMatrixII(int[][] matrix, int target) {
        int n = matrix[0].length;

        // Iterate through each row in the matrix
        for (int[] row : matrix) {
            // Binary search template to find first index where row[mid] >= target
            int left = 0;
            int right = n - 1;
            int firstTrueIndex = -1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (row[mid] >= target) {
                    firstTrueIndex = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            // Check if the position is valid and contains the target value
            if (firstTrueIndex != -1 && row[firstTrueIndex] == target) {
                return true;
            }
        }

        // Target was not found in any row
        return false;
    }
}
