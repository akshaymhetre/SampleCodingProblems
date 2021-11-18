package com.akshay.learning.DP;

public class LongestCommonSubstring {

    private final String str1;
    private final String str2;

    LongestCommonSubstring(String str1, String str2){
        this.str1 = str1;
        this.str2 = str2;
    }
    public int lengthOfLCSRecursion(){
        return _lengthOfLCSRecursion(str1.length(), str2.length(), 0);
    }

    // Indexes are consider from one here
    private int _lengthOfLCSRecursion(int str1Index, int str2Index, int maxLenSoFar){
        if(str1Index == 0 || str2Index == 0){
            return maxLenSoFar;
        }
        // if last char equals, increase maxLenSoFar by one
        if(str1.charAt(str1Index-1) == str2.charAt(str2Index-1)){
            maxLenSoFar = _lengthOfLCSRecursion(str1Index-1, str2Index-1, maxLenSoFar+1);
        }
        // last characters of both strings are not equal
        return Math.max(maxLenSoFar,
                Math.max(
                        _lengthOfLCSRecursion(str1Index-1, str2Index, 0),  // ignore character from first string
                        _lengthOfLCSRecursion(str1Index, str2Index-1, 0)   // ignore char from second string
                ));
    }


    public int lengthOfLCSDP(){
        int[][] cache = new int[str1.length()+1][str2.length()+1];
        int result = 0;  // To store length of the longest common substring

        // Following steps build LCSuff[m+1][n+1] in bottom up fashion
        for (int i = 0; i <= str1.length(); i++)
        {
            for (int j = 0; j <= str2.length(); j++)
            {
                if (i == 0 || j == 0)
                    cache[i][j] = 0;
                else if (str1.toCharArray()[i - 1] == str2.toCharArray()[j - 1])
                {
                    cache[i][j] = cache[i - 1][j - 1] + 1;
                    result = Integer.max(result, cache[i][j]);
                }
                else
                    cache[i][j] = 0;
            }
        }
        return result;
    }
}
