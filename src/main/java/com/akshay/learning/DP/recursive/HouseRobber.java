package com.akshay.learning.DP.recursive;

/*
https://leetcode.com/problems/house-robber/
* You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
* the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house,
* return the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.

* */
public class HouseRobber {
    public int rob(int[] nums) {
        return _rob(nums, nums.length-1);
    }

    private int _rob(int[] nums, int n) {
        if(n < 0){
            return 0;
        }
        return Math.max(_rob(nums, n-1), _rob(nums, n-2) +nums[n]);
    }

    // DP[n] max amount got till houses n
    public int robDP(int[] nums) {
        if (nums.length == 0) return 0;
        int[] DP = new int[nums.length + 1];
        DP[0] = 0; //with 0 house
        DP[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            DP[i+1] = Math.max(DP[i], DP[i-1] + val);
        }
        return DP[nums.length];
    }

    private int robIterative(int[] nums) {
        int prevMax = 0;
        int currMax = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = currMax;
            currMax = Math.max(currMax, prevMax+nums[i]);
            prevMax = temp;
        }
        return currMax;
    }
}
