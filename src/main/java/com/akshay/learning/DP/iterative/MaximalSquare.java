package com.akshay.learning.DP.iterative;

/*

https://leetcode.com/problems/maximal-square/

* Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example 1:

Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 4
* */
public class MaximalSquare {
    /*
    * Thought process: consider only right-bottom corner of square
    * dp(i,j) = min(dp(i−1,j),dp(i−1,j−1),dp(i,j−1))+1
    *
    *
    * */
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = (m == 0) ? 0 : matrix[0].length;
        int maxLen = 0;
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = (matrix[i][0] == '1') ? 1: 0;
            maxLen = Math.max(maxLen, dp[i][0]);
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = (matrix[0][j] == '1') ? 1: 0;
            maxLen = Math.max(maxLen, dp[0][j]);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][j] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen*maxLen;
    }
}
