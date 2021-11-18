package com.akshay.learning.misc;

/*
You are given an integer array nums. You are initially positioned at the array's first index,
and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

Logic:
- Start from end
- set jumpPossibleFromIndex at last element;
- iterate from second last element to first
    - find jump at current, currentJump = nums[i]+i
    - check if jump is greater than jumpPossibleFromIndex, then set jumpPossibleFromIndex = i
* */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int jumpPossibleFromIndex = nums.length-1;
        for (int i = nums.length - 2; i >= 0; i--) {
            int currentJump = nums[i]+i;
            if(currentJump >= jumpPossibleFromIndex){
                jumpPossibleFromIndex = i;
            }
        }
        return jumpPossibleFromIndex == 0;
    }
}
