package com.akshay.learning.misc.PrefixSuffixType.prefixSum;

import java.util.HashSet;

/*
Check if a subarray with 0 sum exists or not
Logic: Difficult to come up with but easy to implement
Traverse the array and maintain the sum of elements seen so far.
If the sum is seen before (i.e., the sum exists in the set), return true as there exists at least one subarray with zero-sum
that ends at the current index;
otherwise, insert the sum into the set.

Input:  { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 }

Output: Subarray with zero-sum exists

The subarrays with a sum of 0 are:

{ 3, 4, -7 }
{ 4, -7, 3 }
{ -7, 3, 1, 3 }
{ 3, 1, -4 }
{ 3, 1, 3, 1, -4, -2, -2 }
{ 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 }

Logic: This is prefix sum type of problem:
- There are two type of ranges possible in this:
- case 1: Range(0, j) with sum 0
    - this means prefix sum has entry 0
- case 2: Range(i, j) with sum 0
    - Range(i, j) = prefixSum[j]-prefixSum[i-1] = 0
    - that means prefixSum[j] == prefixSum[i-1]
    - so there is same sum available in the prefix sum array

    Ultimately, check if prefix sum has 0 or same sum, by using hashset
*/
public class SubArrWithZeroSum {
    public boolean hasZeroSumSubarray(int[] nums){
        HashSet<Integer> prefixSumSet = new HashSet<>();
        prefixSumSet.add(0); // assume zero sum is found so far
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (prefixSumSet.contains(sum)) return true;
            prefixSumSet.add(sum);
        }
        return false;
    }
}
