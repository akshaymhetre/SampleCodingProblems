package com.akshay.learning.sorting;

/*
1. Given an unsorted array 'arr'.
2. Reorder it in-place such that :  arr[0] <= arr[1] >= arr[2] <= arr[3] . . . .
3. Please sort the array in place and do not define additional arrays.
4. Allowed Time Complexity : O(n)

Input: [3, 5, 2, 1, 6, 4]
Output: [1, 6, 2, 5, 3, 4]
* */
public class WiggleSort1 {
    public int[] wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            if(isEven(i)) {
                if(nums[i] > nums[i+1]) {
                    swap(nums, i, i+1);
                }
            } else {
                if(nums[i] < nums[i+1]) {
                    swap(nums, i, i+1);
                }
            }
        }
        return nums;
    }

    private boolean isEven(int i) {
        return i % 2 == 0;
    }

    private void swap(int[] nums, int i, int j) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
     }
}
