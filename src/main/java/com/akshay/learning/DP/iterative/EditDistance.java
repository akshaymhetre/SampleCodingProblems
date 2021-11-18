package com.akshay.learning.DP.iterative;

/*
* Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
You have the following three operations permitted on a word:
    Insert a character
    Delete a character
    Replace a character

* * word1Size X word2Size : word1 = "horse", word2 = "ros"
* NOTE: RANDOM VALUES ADDED BELOW
       +---+---+---+---+---+
(size) |   | r | o | s |
       +---+---+---+---+---+
   (h) | 1 | 0 | 1 | 2 | 3 |
       +---+---+---+---+---+
   (o) | 2 | 0 | 1 | 2 | 3 |
       +---+---+---+---+---+
   (r) | 3 | 0 | 1 | 2 | 3 |
       +---+---+---+---+---+
   (s) | 3 | 0 | 1 | 2 | 3 |
       +---+---+---+---+---+
   (e) | 3 | 0 | 1 | 2 | 3 |
       +---+---+---+---+---+
*
*   dp[i][j] Represents min coins taken to achieve [total = j] with coins from [0....i]
* */
public class EditDistance {
    public int minDistance(String word1, String word2){
        return _minDistance(word1, word2, word1.length(), word2.length());
    }

    private int _minDistance(String word1, String word2, int word1Size, int word2Size){
        int[][] dp = new int[word1Size+1][word2Size+1];
        // for word1 with size 0
        for (int j = 0; j < word2Size; j++) {
            dp[0][j] = word2Size;
        }
        // for word2 with size 0
        for (int i = 0; i < word1Size; i++) {
            dp[i][0] = word1Size;
        }
        for (int i = 1; i < word1Size; i++) {
            for (int j = 1; j < word2Size; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j-1],dp[i-1][j]), dp[i-1][j-1]);
                }
            }
        }
        return dp[word1Size][word2Size];
    }
}
