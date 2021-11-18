package com.akshay.learning.misc.PrefixSuffixType.prefixSum;

public class PrefixSum {
    public int[] getPrefixSum(int[] arr){
        int[] prefixSum = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            prefixSum[i] = ((i == 0) ? 0 : prefixSum[i-1]) + arr[i];
        }
        return prefixSum;
    }
    // usecase get sum of elements from array within range
    // Range(0, 4) =  prefixSum[4]
    // Range(0, 6) =  prefixSum[6]
    // Range(2, 6) =  Range(0, 6)-Range(0, 1) because, Range(0, 6) = Range(0, 1)+Range(2, 6)
    // Range(2, 6) =  prefixSum[6]-prefixSum[1]
    // Formula: Range(i, j) =  prefixSum[j]-prefixSum[i-1] where i > 1
    public int getSumWithinRange(int[] arr, int i, int j){
        int[] prefixSum = getPrefixSum(arr);
        return (i == 0) ? prefixSum[j]: (prefixSum[j]-prefixSum[i-1]);
    }

}
