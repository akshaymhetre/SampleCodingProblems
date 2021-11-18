package com.akshay.learning.DP.recursive;

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
- set minJump to INT_MAX
- To get min jumps from start to end, get min jump from start+step to end where 1 <= step <= arr[start]
- Make sure step doesnt exceed and 1+subJumpCount doesnt become negative

* */
public class JumpGameMin {

    public int jump(int[] arr) {
        /*int[] minJumpsTillIndex = new int[arr.length];
        Arrays.fill(minJumpsTillIndex, Integer.MAX_VALUE-1); //to avoid adding 1 to max
        minJumpsTillIndex[0] = 0; // min jump from 0 to 0, minJumpsTillIndex[i] means min jumps from 0 to i
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                // jump possible
                if(arr[j] + j >= i){
                    minJumpsTillIndex[i] = Math.min(minJumpsTillIndex[i], 1+minJumpsTillIndex[j]);
                }
            }
        }
        return minJumpsTillIndex[arr.length-1];*/
        int minJump = Integer.MAX_VALUE-1;
//        for (int i = 0; i < arr.length; i++) {
//            minJump = Math.min(minJump, jump(arr, i));
//        }
        return minJump;
    }

//    private int jump(int[] arr, int end) {
//        if(end == 0){
//            return 0;
//        }
//        int minJumps = Integer.MAX_VALUE-1;
//        for (int j = 0; j < end; j++) {
//            if(arr[j]+j >= end){
//                minJumps = Math.min(minJumps, arr[j]+j);
//            }
//        }
//        return minJumps;
//    }

    public int reverseInt(int num){
        int res = 0;
        int i = 1;
        while(num > 0){
            res = res*i + (num % 10);
            num = num/10;
            i = 10;
        }
        return res;
    }
}
