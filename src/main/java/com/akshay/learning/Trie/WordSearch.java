package com.akshay.learning.Trie;

/*
https://leetcode.com/problems/word-search/
* Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally
* or vertically neighboring. The same letter cell may not be used more than once.
*
* Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
* */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(exist(board, i, j, 0, word)) return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int x, int y, int i, String word) {
        if(i == word.length()) {
            return true;
        }
        if(x < 0 || x >= board.length || y < 0 || y >= board[x].length) return false;
        if(board[x][y] != word.charAt(i)) return false;
        board[x][y] ^= 256; // change character at x,y
        boolean exist = exist(board, x + 1, y, i + 1, word) ||
                exist(board, x, y + 1, i + 1, word) ||
                exist(board, x - 1, y, i + 1, word) ||
                exist(board, x, y - 1, i + 1, word);
        board[x][y] ^= 256; // revert character at x,y
        return exist;
    }
}
