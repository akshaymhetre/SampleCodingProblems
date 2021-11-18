package com.akshay.learning.DP.recursive;

/*
* Given a rod of length n inches and an array of prices that includes prices of all pieces of size smaller than n.
* Determine the maximum value obtainable by cutting up the rod and selling the pieces.
* For example, if the length of the rod is 8 and the values of different pieces are given as the following,
* then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
*
* length   | 1   2   3   4   5   6   7   8
--------------------------------------------
  price    | 1   5   8   9  10  17  17  20
  *
  * Logic:
  * maxProfitTillLen(n) = MAX(profitOfLen(n) + maxProfitTillLen(n-i-1)) for every 0 < i < n
* */
public class CuttingRod {

    public int maxValue(int[] price, int rodLength){
        if(rodLength == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < rodLength; i++) {
            max = Math.max(max, price[i] + maxValue(price, rodLength-i-1));
        }
        return max;
    }

}
