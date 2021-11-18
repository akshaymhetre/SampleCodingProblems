package com.akshay.learning.misc.slidingWindow;

/*
* Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

Example 1:
                       s e
Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
*
  [1,1,1,0,1,0,0,1,1,1,0]
           i p
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]

* */
public class MaxConsecutiveFlipOne {

    // Time taken : 2 ms
    /*
    * Logic: Keep two pointers of sliding window start and end = 0
    * - Increment end pointer
    *    - if 0 found increment zero counter
    *    - if 0 count is greater than given limit K, then shrink window by increasing left pointer till zeroCount is within limit (start++)
    *  - at every stage maintain result
    * */
    public int longestOnes(int[] nums, int k) {
        int zeroCount=0,start=0,res=0;
        for(int end=0;end<nums.length;end++){
            if(nums[end] == 0) zeroCount++;
            while(zeroCount > k){
                if(nums[start] == 0) zeroCount--;
                start++;
            }
            res=Math.max(res,end-start+1);
        }
        return res;
    }
    // Tme taken : 1489 ms
    // Working but ignore
    public int longestOnes1(int[] nums, int k) {
        int lenSoFar = 0;
        int max = 0;
        int flipSoFar = 0; // count number of flips
        int prevFlipIndex = -1;
        int i = 0;
        //{0,0,1,1,1,0,0}
        while (i < nums.length) {
            if(nums[i] == 1){
                lenSoFar++;
                i++;
            } else {
                if(k == 0){
                    lenSoFar = 0;
                    i++;
                }else if(flipSoFar < k){
                    if(prevFlipIndex == -1) prevFlipIndex = i;
                    lenSoFar++;
                    flipSoFar++;
                    i++;
                } else {
                    i = prevFlipIndex+1;
                    prevFlipIndex = -1;
                    flipSoFar = lenSoFar = 0;
                }
            }
            max = Math.max(max, lenSoFar);
        }
        return max;
    }

    /*
    * Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.
    * You must delete one element



Example 1:

Input: nums = [1,1,0,1]
Output: 3
Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
Example 2:

Input: nums = [0,1,1,1,0,1,1,0,1]
Output: 5
Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
Example 3:

Input: nums = [1,1,1]
Output: 2
Explanation: You must delete one element.
* */
    public int longestSubarray(int[] nums) {
        int start = 0, zeroCount = 0, res = 0;
        for (int end = 0; end < nums.length; end++) {
            if(nums[end] == 0){
                zeroCount++;
                while (zeroCount > 1){
                    if(nums[start] == 0) zeroCount--;
                    start++;
                }
            }
            res = Math.max(res, end-start+1-zeroCount);
        }
        if(res == nums.length) res -= 1; // all are ones, no zero found, as you must delete at lease one element
        return res;
    }

}
