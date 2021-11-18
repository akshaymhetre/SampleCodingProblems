package com.akshay.learning.DP.recursive;

import static java.lang.Math.max;
//https://www.programcreek.com/2014/06/leetcode-word-search-ii-java/

/*
*
* */
public class EggDrop {
    public int eggDrop(int totalEggs, int totalFloors){
        if(totalFloors == 0 || totalFloors == 1){
            return totalFloors;
        }
        if(totalEggs == 1){
            return totalFloors;
        }
        int minChancesTaken = Integer.MAX_VALUE;
        for (int currFloor = 1; currFloor <= totalFloors; currFloor++) {
            int worstCaseChancesTakenForCurrFloor =
                    Math.max(
                            // egg breaks on currFloor, then reduce egg count and check for floors below currFloor
                            eggDrop(totalEggs-1, currFloor-1),
                            // if egg doesnt break on currFloor, then check for remaining floors
                            eggDrop(totalEggs-1, totalFloors-currFloor)
                    );
            minChancesTaken = Math.min(minChancesTaken, worstCaseChancesTakenForCurrFloor);
        }
        return minChancesTaken+1; // *******IMPORTANT********
    }
}
