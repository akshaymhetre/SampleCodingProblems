package com.akshay.learning.DP.recursive;

/*
* Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
*
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
* */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int totalIslands = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '1'){
                    totalIslands++;
                    markIslandFound(grid, i, j, m, n);
                }
            }
        }
        return totalIslands;
    }

    private void markIslandFound(char[][] grid, int i, int j, int m, int n) {
        if(!withinBoundry(i, j, m, n)) return;
        if(grid[i][j] == '1') {
            grid[i][j] = '2';
            markIslandFound(grid, i-1, j, m, n);
            markIslandFound(grid, i, j-1, m, n);
            markIslandFound(grid, i+1, j, m, n);
            markIslandFound(grid, i, j+1, m, n);
        }
    }

    private boolean withinBoundry(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }


}
