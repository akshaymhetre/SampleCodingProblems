package com.akshay.learning.misc.PrefixSuffixType;

import java.util.Arrays;

/*
* There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

1. Each child must have at least one candy.
2. Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
* Example:

Input 1:
    A = [1, 2]
Output 1:
    3

Explanation 1:
    The candidate with 1 rating gets 1 candy and candidate with rating cannot get 1 candy as 1 is its neighbor.
    So rating 2 candidate gets 2 candies. In total, 2 + 1 = 3 candies need to be given out.

Input 2:
    A = [1, 5, 2, 1]
    *
    * [1, 3, 2, 1]

Output 2:
    7

Explanation 2:
    Candies given = [1, 3, 2, 1]
* */
public class DistributeCandy {
    public int minCandy(int[] A) {
        if (A.length < 2) {
            return A.length;
        }

        int[] candies = new int[A.length];
        Arrays.fill(candies, 1);

        // ** Step 1: Forward **
        for (int i=0; i<A.length-1; i++) {
            int curr = A[i];
            int next = A[i + 1];
            if (curr < next) {
                candies[i + 1] = candies[i] + 1;
            }
        }

        // ** Step 2: Backward **
        for (int i=A.length-1; i>0; i--) {
            int curr = A[i];
            int prev = A[i - 1];
            if (curr < prev) {
                // prevCandiesCnt = Math.max(currCandiesCount + 1, prevCandiesCnt);
                candies[i - 1] = Math.max(candies[i - 1], candies[i] + 1);
            }
        }

        // ** Step 3: Count Candies **
        return Arrays.stream(candies).sum();
    }






}
