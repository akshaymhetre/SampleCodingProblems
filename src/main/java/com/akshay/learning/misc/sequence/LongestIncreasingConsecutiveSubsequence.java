package com.akshay.learning.misc.sequence;

import java.util.HashMap;
import java.util.Map;

/*
Given N elements, write a program that prints the length of the longest increasing subsequence whose adjacent element difference is one.
Examples:

Input : a[] = {3, 10, 3, 11, 4, 5, 6, 7, 8, 12}
Output : 6
Explanation: 3, 4, 5, 6, 7, 8 is the longest increasing subsequence whose adjacent element differs by one.
*/
public class LongestIncreasingConsecutiveSubsequence {
    public int lengthOfLICS(int[] arr){
        Map<Integer, Integer> consecutiveNumberSize = new HashMap<>();
        int resMaxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            if(consecutiveNumberSize.containsKey(arr[i]-1)){
                consecutiveNumberSize.put(arr[i], consecutiveNumberSize.get(arr[i]-1)+1);
            } else if(!consecutiveNumberSize.containsKey(arr[i])){
                consecutiveNumberSize.put(arr[i], 1);
            }
            resMaxLength = Math.max(resMaxLength, consecutiveNumberSize.get(arr[i]));
        }
        return resMaxLength;
    }
}
