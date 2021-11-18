package com.akshay.learning.DP.recursive;

import java.util.Arrays;

/*
*
* Given a set of positive numbers, find if we can partition it into two subsets
* such that the sum of elements in both the subsets is equal,
* Input: {1, 2, 3, 4}
  Output: True
  Explanation: The given set can be partitioned into two subsets with equal sum: {1, 4} & {2, 3}
*
* */
public class IsEqualSumSubsetRecursive {
    public boolean solution(int[] nums){
        int sum = Arrays.stream(nums).sum();
        // if sum is odd then cannot be divided
        if(!isEven(sum)) return false;
        // find subset with HALF sum similar to knapsack problem
        int subsetSum = sum / 2;
        return isSubsetWithGivenSum(nums, subsetSum, 0);
    }

    private boolean isSubsetWithGivenSum(int[] nums, int sum, int currentIndex) {
        if(sum == 0)
            return true;
        if(nums.length == 0 || currentIndex >= nums.length)
            return false;
        if(nums[currentIndex] <= sum){
            if(isSubsetWithGivenSum(nums, sum-nums[currentIndex], currentIndex+1)){
                return true;
            }
        }

        return isSubsetWithGivenSum(nums, sum, currentIndex+1);
    }

    /*
    // This is also valid, but difficult to remember
    boolean isEven(int n) {
        return (n ^ 1) == n + 1;
    }*/
    boolean isEven(int n) {
        return (n & 1) == 0;
    }
}
