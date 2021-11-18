package com.akshay.learning.DP.recursive;

/*
* Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
You have the following three operations permitted on a word:
    Insert a character
    Delete a character
    Replace a character

Example 1:
    Input: word1 = "horse", word2 = "ros"
    Output: 3
    Explanation:
    horse -> rorse (replace 'h' with 'r')
    rorse -> rose (remove 'r')
    rose -> ros (remove 'e')
    *
    * Logic:
    * minD(w1, w2) =
    *           case w1.last == w2.last :  minD(w1-1, w2-1)
    *           else :  MIN(minD(w1-1, w2), minD(w1, w2-1), minD(w1-1, w2-1))
* */
public class EditDistance {
    public int minDistance(String word1, String word2){
        return _minDistance(word1, word2, word1.length(), word2.length());
    }

    private int _minDistance(String word1, String word2, int word1Size, int word2Size){
        if(word1Size == 0){
            return word2Size;
        }
        if(word2Size == 0){
            return word1Size;
        }
        // case1: if last char matches
        if(word1.charAt(word1Size-1) == word2.charAt(word2Size-1)){
            return _minDistance(word1, word2, word1Size-1, word2Size-1);
        }
        return 1 + Math.min(
                Math.min(
                        _minDistance(word1, word2, word1Size-1, word2Size),
                        _minDistance(word1, word2, word1Size, word2Size-1)
                ),
                _minDistance(word1, word2, word1Size-1, word2Size-1)
        );
    }
}
