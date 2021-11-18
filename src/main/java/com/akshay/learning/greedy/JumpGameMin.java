package com.akshay.learning.greedy;

import java.util.Arrays;

/*
Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Your goal is to reach the last index in the minimum number of jumps.
You can assume that you can always reach the last index.

Example 1:
Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2

Logic:


* */

public class JumpGameMin {
    public int jumpGreedy(int[] arr) {
        //take first jump
        int stepsRemaining = arr[0];
        int maxReach = 0+arr[0]; //from 0 index to value in arr[0]
        int totalJumpSoFar = 1;
        int length = arr.length;

        // corner cases
        if(length == 1) return 0;
        else if(arr[0] == 0) return -1;

        // try walking with stepsRemaining
        for (int i = 1; i < length; i++) {
            // Last index reached
            if(i == length-1){
                return totalJumpSoFar;
            }
            //update maxReach at each iteration
            maxReach = Math.max(maxReach, i+arr[i]);
            // reducing step at each iteration
            stepsRemaining--;
            // if steps are over
            if(stepsRemaining == 0){
                // if current index goes ahead or equal to max reach, then jump not possible
                if(i >= maxReach){
                    return -1;
                }
                // as steps are over we need to take jump
                totalJumpSoFar++;
                // step remaining will be maxReach remaining from current index
                stepsRemaining = maxReach-i;
            }
        }
        return totalJumpSoFar;
    }

    public int jumpDP(int[] arr) {
        int[] minJumpsTillIndex = new int[arr.length];
        Arrays.fill(minJumpsTillIndex, Integer.MAX_VALUE-1); //to avoid adding 1 to max
        minJumpsTillIndex[0] = 0; // min jump from 0 to 0, minJumpsTillIndex[i] means min jumps from 0 to i
        for (int tillIndex = 1; tillIndex < arr.length; tillIndex++) {
            for (int srcIndex = 0; srcIndex < tillIndex; srcIndex++) {
                // jump possible
                //case found where jump going beyond tillIndex
                int jumpFromSrcIndex = srcIndex + arr[srcIndex];
                if(jumpFromSrcIndex >= tillIndex){
                    // update min jump count for tillIndex
                    minJumpsTillIndex[tillIndex] = Math.min(minJumpsTillIndex[tillIndex], 1+minJumpsTillIndex[srcIndex]);
                }
            }
        }
        return minJumpsTillIndex[arr.length-1];
    }
}
