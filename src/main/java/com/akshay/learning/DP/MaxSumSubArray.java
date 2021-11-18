package com.akshay.learning.DP;

//Array might contain negative numbers
// Logic: As array might contain negative numbers, below algo is mixture of greedy and DP
/* Kadane’s Algorithm
* - keep two max
* - one maxSumSoFar will keep max till index i, by either including element in the sum or not including and only taking that element
* - keep finalMax to track maximum sum
* */
public class MaxSumSubArray {
    public int maxSumSubArr(int[] arr){
        if(arr == null || arr.length == 0) return -1;
        int max = arr[0] ;
        int maxSumSoFar = arr[0];

        for(int i = 1; i < arr.length; i++){
            maxSumSoFar = Math.max(maxSumSoFar+arr[i], arr[i]);
            max = Math.max(max, maxSumSoFar);
        }
        return max;

    }
}
