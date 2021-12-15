package com.akshay.learning.sorting.quickSortType.QuickSelect;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-largest-element-in-an-array/
/*
* Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.



Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
* */
public class KthLargest {
    //Best approach: Quick select: Average case: O(n)
    public int findKthLargest(int[] nums, int k) {
        final int length = nums.length;
        int low = 0, high = length -1;
        return _findKthLargest(nums, low, high, length-k+1);
    }

    private int _findKthLargest(int[] nums, int low, int high, int k) {
        if(low < high) {
            int partitionIndex = partition(nums, low, high, k);
            if(partitionIndex == k-1){
                return nums[partitionIndex];
            } else if(partitionIndex < k-1) {
                return _findKthLargest(nums, partitionIndex+1, high, k);
            } else {
                return _findKthLargest(nums, low, partitionIndex-1, k);
            }
        }
        // Important for case: Input:  [-1,2,0], k = 1 OR Input: [1], k = 1
        return nums[low];
    }

    private int partition(int[] nums, int low, int high, int k) {
        int pivot = nums[high];
        int i = low-1;
        for (int j = low; j < high; j++) {
            if(nums[j] <= pivot){
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i+1, high);
        return i+1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //First approach: Sort and get : O(N lg N) running time + O(1) memory
    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        final int length = nums.length;
        return nums[length -k];
    }

    //Second approach: MIN HEAP of size K : O(N lg K) running time + O(K) memory
    public int findKthLargest2(int[] nums, int k) {
        final PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num :
                nums) {
            priorityQueue.offer(num);
            if(priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }
        return priorityQueue.peek();
    }
}
