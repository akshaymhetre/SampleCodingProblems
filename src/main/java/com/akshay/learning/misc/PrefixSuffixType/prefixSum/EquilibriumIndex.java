package com.akshay.learning.misc.PrefixSuffixType.prefixSum;

import java.util.Arrays;

/*
* Input: A[] = [-7, 1, 5, 2, -4, 3, 0], Output: 3
* Explanation: 3 is an equilibrium index A[0] + A[1] + A[2] = A[4] + A[5] + A[6]
*
* Input: A[] = [0, 1, 3, -2, -1], Output: 1
* Explanation: 1 is an equilibrium index, A[0] = A[2] + A[3] + A[4]
*
* Logic:
* Again logic is similar to prefix sum:
* Take two variable leftSum and rightSum
* leftSum is always prefix sum till i where 0 < i < len
* rightSum = totalSum - leftsum - equil
* */
public class EquilibriumIndex {
    public int getEquilibriumIndex(int[] arr){
        int totalSum = Arrays.stream(arr).sum();
        int leftSum = 0;
        for (int equilibriumIndex = 1; equilibriumIndex < arr.length; equilibriumIndex++) {
            leftSum += arr[equilibriumIndex-1];
            int rightSum = totalSum - leftSum - arr[equilibriumIndex];
            if(leftSum == rightSum)
                return equilibriumIndex;

        }
        return -1;
    }
}
