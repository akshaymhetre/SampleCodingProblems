package com.akshay.learning.DP.iterative;

/*
*
 - Given coins of different denominations and a total, in how many ways can we combine these coins to get the total?
   Let's say we have coins = {1, 2, 3} and total = 5, we can get the total in 5 ways:
• 1 1 1 1 1
• 1 1 1 2
• 1 1 3
• 1 2 2
• 2 3

* CoinDenomination X TotalValueCanAchieved
     +---+---+---+---+---+---+---+
(den)|   | 0 | 1 | 2 | 3 | 4 | 5 |
     +---+---+---+---+---+---+---+
 (1) | 0 | 1 | 1 | 1 | 1 | 1 | 1 |
     +---+---+---+---+---+---+---+
 (2) | 1 | 1 | 1 | 2 | 2 | 3 | 3 |
     +---+---+---+---+---+---+---+
 (3) | 2 | 1 | 1 | 2 | 3 | 4 | 5 |
     +---+---+---+---+---+---+---+
     *
     * dp[i][j] Represents total ways taken to achieve [total = j] with coins from [0....i]
* */
public class CoinChangeTotalWays {
    int solution(int coins[], int total){
        int dp[][] = new int[coins.length][total+1];
        // init dp
        for(int i = 0; i < coins.length ; i++)
            dp[i][0] = 1;

        for(int j = 1; j <= total ; j++)
            dp[0][j] = (coins[0] < j) ? 1 : dp[0][j-1];

        for(int i = 1; i < coins.length ; i++){
            for(int j = 1; j <= total ; j++){
                if(coins[i] > j){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i]];
                }
            }
        }
        //ArrayUtils.printArray(dp, coins.length, total);
        return dp[coins.length-1][total];
    }
}
