package com.akshay.learning.DP.recursive;

/*
* Given an m x n integers matrix, return the length of the longest increasing path in matrix.

From each cell, you can either move in four directions: left, right, up, or down.
* You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).

 Example 1:

Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
Output: 4
Explanation: The longest increasing path is [1, 2, 6, 9].*/
public class LongestPathMatrix {
    // Logic: find the longest path for each cell considering as starting point
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int maxLen = 0;
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxLen = Math.max(maxLen, dfs(matrix, m, n, dp, i, j)+1);
            }
        }
        return maxLen;
    }

    private int dfs(int[][] matrix, int m, int n, int[][] dp, int i, int j) {
        if(i < 0 || i >= m || j < 0 || j >= n){
            return 0;
        }
        if(dp[i][j] > 0) return dp[i][j];
        if(i-1 >= 0 && matrix[i-1][j] > matrix[i][j]){
            dp[i][j] = Math.max(dp[i][j], dfs(matrix, m, n, dp, i-1, j)+1);
        }
        if(j-1 >= 0 && matrix[i][j-1] > matrix[i][j]){
            dp[i][j] = Math.max(dp[i][j], dfs(matrix, m, n, dp, i, j-1)+1);
        }
        if(i+1 < m && matrix[i+1][j] > matrix[i][j]){
            dp[i][j] = Math.max(dp[i][j], dfs(matrix, m, n, dp, i+1, j)+1);
        }
        if(j+1 < n && matrix[i][j+1] > matrix[i][j]){
            dp[i][j] = Math.max(dp[i][j], dfs(matrix, m, n, dp, i, j+1)+1);
        }
        return dp[i][j];
    }
}
