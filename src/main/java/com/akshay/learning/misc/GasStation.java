package com.akshay.learning.misc;
/*
*
* There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station.
You begin the journey with an empty tank at one of the gas stations.

Given two integer arrays gas and cost, return the starting gas station's index
if you can travel around the circuit once in the clockwise direction, otherwise return -1.
If there exists a solution, it is guaranteed to be unique

Example 1:

Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
Output: 3
Explanation:
Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 4. Your tank = 4 - 1 + 5 = 8
Travel to station 0. Your tank = 8 - 2 + 1 = 7
Travel to station 1. Your tank = 7 - 3 + 2 = 6
Travel to station 2. Your tank = 6 - 4 + 3 = 5
Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
Therefore, return 3 as the starting index.
*
* Logic: Keep track of total += gas[i]-cost[i] where 0 <= i <= n
* if at the end total is still negative then traversal is not possible
*
* [1,2,3,4,5]
  [3,4,5,1,2]

* */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, tank = 0, start = 0;
        for(int i = 0; i < gas.length; i++){
            tank += gas[i]-cost[i];
            total += tank; // keep track of total Summation(gas-cost)
            System.out.println("total: "+total+", tank: " +tank);
            if(tank <= 0){ // tank cannot be negative reset to 0 and set start index to i+1
                tank = 0;
                start = i+1;
            }
        }
        return (total < 0) ? -1 : start; // at the end total should not be negative for valid result
    }
}
