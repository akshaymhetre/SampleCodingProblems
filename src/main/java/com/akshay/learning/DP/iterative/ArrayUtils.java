package com.akshay.learning.DP.iterative;

public class ArrayUtils {
    public static void printArray(int[][] dp, int length, int total) {
        for(int i = 0; i < length ; i++){
            for(int j = 0; j <= total ; j++){
                System.out.print(" "+ dp[i][j]);
            }
            System.out.println();
        }
    }
}
