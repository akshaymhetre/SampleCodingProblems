package com.akshay.learning.misc.matrix;

/*
* Rotate Image: https://leetcode.com/problems/rotate-image/
* You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
* DO NOT allocate another 2D matrix and do the rotation.
*
* Input: matrix = [[1,2,3],  ->   1 4 7
*                  [4,5,6],       2 5 8
*                  [7,8,9]]       3 6 9
Output: [[7,4,1],
*        [8,5,2],
*        [9,6,3]]
* */
public class RotateMatrix {
    // https://leetcode.com/problems/rotate-image/solution/
    public int[][] rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i ++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        return matrix;

    }

    public void rotateNew(int[][] matrix) {
        transpose(matrix);
        reflect(matrix);
    }

    /*
    * * Input: matrix = [[1,2,3],  ->   1 4 7
     *                  [4,5,6],       2 5 8
     *                  [7,8,9]]       3 6 9
     * */
    public void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }

    public void reflect(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }
}
