package com.akshay.learning.DP;

public class KnapsackBinary {
    public int knapsackRecursion(int capacity, int[] weights, int[] profits, int totalCount) {
        if (totalCount == 0 || capacity == 0)
            return 0;
        if (weights[totalCount-1] > capacity){
            // weight is larger than bag capacity, then do not consider and just reduce totalCount
            return knapsackRecursion(
                    capacity,
                    weights,
                    profits,
                    totalCount-1);
        }
        else {

            return Integer.max(
                    profits[totalCount - 1] +
                            knapsackRecursion(
                                    capacity - weights[totalCount - 1],
                                    weights,
                                    profits,
                                    totalCount - 1),

                    knapsackRecursion(
                            capacity,
                            weights,
                            profits,
                            totalCount - 1)
            );
        }
    }

    public int knapsackDP(int capacity, int[] weights, int[] profits, int totalCount) {

        // there only two variables here knapsackDP(capacity, totalCount) will create cache with that only
        // to reduce recursive calls
        int cache[][] = new int[totalCount+1][capacity+1];

        // Build table cache[][] in bottom up manner
        for(int item = 0 ; item <= totalCount; item++){  // item = 1 will be first item from th list
            for(int _capacity = 0 ; _capacity <= capacity ; _capacity++){
                if(item == 0 || _capacity == 0){
                    cache[item][_capacity] = 0;
                }
                else if(weights[item-1] <= _capacity) { // item-1 will be current item from the list, each item will go bcoz of for loop
                    final int currentItemProfit = profits[item - 1];
                    final int currentItemWeight = weights[item - 1];
                    cache[item][_capacity] = Integer.max(currentItemProfit + cache[item-1][_capacity- currentItemWeight], cache[item-1][_capacity]);
                } else {
                    cache[item][_capacity] = cache[item-1][_capacity];
                }
            }
        }
        return cache[totalCount][capacity];
    }

}
