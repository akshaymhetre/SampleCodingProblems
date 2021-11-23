package com.akshay.learning.misc.binarySearch;

public class UpperLowerBoundSorted {
    // 2,6,9,10,14 <--- find upper bound for 7 -> ans = 2, before 9
    public int getUpperBoundIndex(int[] nums, int x){
        int low = 0, high = nums.length-1;
        while(low <= high){
            int mid = (low+high) >> 1;
            if(x <= nums[mid]){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        // multiple occurence
        if(low != nums.length-1 && nums[low] == x){
            return low+1;
        }
        return low;
    }

    public int getLowerBoundIndex(int[] nums, int x){
        int low = 0, high = nums.length-1;
        while(low <= high){
            int mid = (low+high) >> 1;
            if(x > nums[mid]){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        // multiple occurence
        if(high != 0 && nums[high] == x){
            return high-1;
        }
        return high;
    }
}
