package com.akshay.learning.misc.PrefixSuffixType.prefixSuffixMax;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
* Hard
* Given n non-negative integers representing an elevation map where the width of each bar is 1,
* compute how much water it can trap after raining.
*
* Example 1:

Please check example diagram : https://leetcode.com/problems/trapping-rain-water/
*
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
* In this case, 6 units of rain water (blue section) are being trapped.
*
* */
public class RainWaterTrap {

    /*
     * Solution : T(n) and S(1)
     * Logic : Keep two pointers, https://www.youtube.com/watch?v=m18Hntz4go8
     * */
    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int leftMax = 0;
        int rightMax = 0;
        int res = 0;
        while (left <= right){
            if(height[left] <= height[right]){
                if(leftMax < height[left]){
                    leftMax = height[left];
                } else {
                    res += leftMax-height[left];
                }
                left++;
            } else {
                if(rightMax < height[right]){
                    rightMax = height[right];
                } else {
                    res += rightMax-height[right];
                }
                right--;
            }
        }
        return res;
    }

    /*
    * Solution : T(n) and S(2n)
    * Logic : Find prefix max and suffix max
    * At each index find min from prefixMax and suffixMax minus current height that much amount of water can be save at that index
    * */
    public int trap1(int[] height) {
        int[] prefixMax = getPrefixMax(height);
        System.out.println(Arrays.toString(prefixMax));
        int[] suffixMax = getSuffixMax(height);
        System.out.println(Arrays.toString(suffixMax));
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            int trappedWater = Math.min(prefixMax[i], suffixMax[i]) - height[i];
            if(trappedWater > 0)
                res += trappedWater;
        }
        return res;
    }

    private int[] getSuffixMax(int[] height) {
        int[] suffixMax = new int[height.length];
        int max = suffixMax[height.length-1] = height[height.length-1];
        for (int i = height.length-2; i >= 0; i--) {
            max = suffixMax[i] = Math.max(height[i], max);
        }
        return suffixMax;
    }

    private int[] getPrefixMax(int[] height) {
        int[] prefixMax = new int[height.length];
        int max = prefixMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            max = prefixMax[i] = Math.max(height[i], max);
        }
        return prefixMax;
    }
}
