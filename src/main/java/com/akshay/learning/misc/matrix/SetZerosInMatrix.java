package com.akshay.learning.misc.matrix;

/*
* Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's, and return the matrix.

You must do it in place.
* Input: matrix = [[1,1,1],
*                  [1,0,1],
*                  [1,1,1]]
Output: [[1,0,1],
*        [0,0,0],
*        [1,0,1]]
*
* Constraints:

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-2^31 <= matrix[i][j] <= 2^31-1
*
* Logic: Use first row and first column as flags, also make sure find special case if m[0][0] is zero
* */
public class SetZerosInMatrix {
    public int[][] setZeroes(int[][] matrix) {
        boolean hasFirstRowZero = false, hasFirstColZero = false;
        for (int i = 0; i < matrix[0].length; i++) {
            if(matrix[0][i] == 0) {
                hasFirstRowZero = true;
                break;
            }
        }

        for (int[] row : matrix) {
            if (row[0] == 0) {
                hasFirstColZero = true;
                break;
            }
        }

        // set flags
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0){
                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }

        // set row or column as per the flag
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        // if first row and column zero cases
        for (int i = 0; i < matrix[0].length && hasFirstRowZero; i++) {
            matrix[0][i] = 0;
        }

        for (int i = 0; i < matrix.length && hasFirstColZero; i++) {
            matrix[i][0] = 0;
        }

        return matrix;
    }
}
