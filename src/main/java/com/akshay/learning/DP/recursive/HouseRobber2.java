package com.akshay.learning.DP.recursive;

/*

Same like first but this time houses are in circular order:
* You are a professional robber planning to rob houses along a street.
*
* Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house,
return the maximum amount of money you can rob tonight without alerting the police.

Logic:
Lets say if we have houses from 1 to 9
We can divide this problem to two sub problems:
Let's take following example:
Subproblem 1: rob house 1 ~ 8
Subproblem 2: rob house 2 ~ 9
And find the bigger one of these two sub problems.


* */
public class HouseRobber2 {
    public int rob(int[] nums){
        if(nums.length == 1) return nums[0];
        return Math.max(robCase1(nums), robCase2(nums));
        // return Math.max(robForBothCase(nums, 0, nums.length - 1), robCase2(nums, 1, nums.length));
    }

    // notice low and high of loop
    private int robCase1(int[] nums) {
        int prevMax = 0;
        int currMax = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int temp = currMax;
            currMax = Math.max(currMax, prevMax+nums[i]);
            prevMax = temp;
        }
        return currMax;
    }

    private int robCase2(int[] nums) {
        int prevMax = 0;
        int currMax = 0;
        for (int i = 1; i < nums.length; i++) {
            int temp = currMax;
            currMax = Math.max(currMax, prevMax+nums[i]);
            prevMax = temp;
        }
        return currMax;
    }

    // common function
    private int robForBothCase(int[] nums, int low, int high) {
        int prevMax = 0;
        int currMax = 0;
        for (int i = low; i < high; i++) {
            int temp = currMax;
            currMax = Math.max(currMax, prevMax+nums[i]);
            prevMax = temp;
        }
        return currMax;
    }
}
