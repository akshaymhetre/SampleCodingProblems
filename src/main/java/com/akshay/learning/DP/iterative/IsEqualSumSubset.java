package com.akshay.learning.DP.iterative;

import java.util.Arrays;

/*
*
* Given a set of positive numbers, find if we can partition it into two subsets
* such that the sum of elements in both the subsets is equal,
* Input: {1, 2, 3, 4}
  Output: True
  Explanation: The given set can be partitioned into two subsets with equal sum: {1, 4} & {2, 3}
*
*   As total sum is {1, 2, 3, 4}.sum() = 10, we need to look for sum with subset 10/2 i.e upto 5
* * NumberFromSet X SumToObtained
     +---+---+---+---+---+---+---+
(num)|   | 0 | 1 | 2 | 3 | 4 | 5 |
     +---+---+---+---+---+---+---+
 (1) | 0 | T | T | F | F | F | F |
     +---+---+---+---+---+---+---+
 (2) | 1 | T | T | T | T | F | F |
     +---+---+---+---+---+---+---+
 (3) | 2 | T | T | T | T | T | T |
     +---+---+---+---+---+---+---+
 (4) | 2 | T | T | T | T | T | T |
     +---+---+---+---+---+---+---+
* */
public class IsEqualSumSubset {
    public boolean solution(int[] nums){
        int sum = Arrays.stream(nums).sum();
        // if sum is odd then cannot be divided
        if(!isEven(sum)) return false;
        // find subset with HALF sum similar to knapsack problem
        int subsetSum = sum / 2;

        boolean[][] dp = new boolean[nums.length][subsetSum+1];
        // init dp
        for(int i = 0; i < nums.length; i++)
            dp[i][0] = true; // sum 0 can be achieved by not taking any number

        // with only one number, we can form a subset only when the required sum is equal to its value
        for(int j = 1; j < nums.length; j++)
            dp[0][j] = (nums[0] == j);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= subsetSum; j++) {
                boolean a = dp[i - 1][j];  // if we can get the sum 's' without the number at index 'i'
                boolean b = (nums[i] <= j) ? dp[i][j - nums[i]] : false; // if we can get the sum 's' with the number at index 'i'
                dp[i][j] = a || b;

            }
        }
        return dp[nums.length-1][subsetSum];

    }
    boolean isEven(int n) {
        return (n ^ 1) == n + 1;
    }
}
