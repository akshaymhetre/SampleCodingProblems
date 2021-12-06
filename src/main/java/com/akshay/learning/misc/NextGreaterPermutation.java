package com.akshay.learning.misc;

/*
* https://www.youtube.com/watch?v=LuLCLgMElus
* Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory.

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]
Example 4:

Input: nums = [1]
Output: [1]
* */
public class NextGreaterPermutation {
    /*
    * - Find first lesser element X from right side
    * - find first element Y greater than X from right side
    * - Swap X AND Y
    * - reverse elements next to first lesser element till the end
    * */
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        while (i >= 0 && nums[i] >=nums[i+1]){
            i--;
        }
        // found X;
        if(i > 0){
            int j = nums.length-1;
            while (nums[i] >= nums[j]){
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i+1);
    }

    private void reverse(int[] nums, int start) {
        int last = nums.length-1;
        while (start < last){
            swap(nums, start, last);
            start++;
            last--;
        }
    }

    private void swap(int[] nums, int i, int j) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
     }

}
