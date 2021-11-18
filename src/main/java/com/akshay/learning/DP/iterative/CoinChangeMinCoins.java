package com.akshay.learning.DP.iterative;

/*
*
 - Given coins of different denominations and a total, in how many ways can we combine these coins to get the total?
   Let's say we have coins = {1, 5, 6, 8} and total = 11, we can get total in minimum coins: 2, which is {5, 6}

* CoinDenomination X TotalValueCanAchieved
       +---+---+---+---+---+---+---+---+---+---+---+---+---+
(denom)|   | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10| 11|
       +---+---+---+---+---+---+---+---+---+---+---+---+---+
   (1) | 0 | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10| 11|
       +---+---+---+---+---+---+---+---+---+---+---+---+---+
   (5) | 1 | 0 | 1 | 2 | 3 | 4 | 1 | 2 | 3 | 4 | 5 | 2 | 3 |
       +---+---+---+---+---+---+---+---+---+---+---+---+---+
   (6) | 2 | 0 | 1 | 2 | 3 | 4 | 1 | 1 | 2 | 3 | 4 | 2 | 2 |
       +---+---+---+---+---+---+---+---+---+---+---+---+---+
   (8) | 3 | 0 | 1 | 2 | 3 | 4 | 1 | 1 | 2 | 1 | 2 | 2 | 2 |
       +---+---+---+---+---+---+---+---+---+---+---+---+---+
*
*   dp[i][j] Represents min coins taken to achieve [total = j] with coins from [0....i]
* */

public class CoinChangeMinCoins {
    int solution(int coins[], int total){
        int dp[][] = new int[coins.length][total+1];
        // init dp
        // 0 total can achive by taking 0 coins
        for(int i = 0; i < coins.length ; i++)
            dp[i][0] = 0;

        // for first coin set the correct values
        for(int j = 1; j <= total ; j++)
            dp[0][j] = (coins[0] <= j) ? 1+dp[0][j-1] : 0;

        for(int i = 1; i < coins.length ; i++){
            for(int j = 1; j <= total ; j++){
                if(coins[i] > j){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i]]);
                }
            }
        }
        ArrayUtils.printArray(dp, coins.length, total);
        return dp[coins.length-1][total];
    }
}
