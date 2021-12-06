package com.akshay.learning.misc;

import java.util.ArrayList;
import java.util.List;

/*
* Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

            1
           1 1
          1 2 1
         1 3 3 1
        1 4 6 4 1

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]*/
public class PascalTriangle {
    /*
    * Logic -
    * Solution 1:
    *   - Computing from start to end for prev row values
    *   - Given row - [1,3,3,1]
    *   - Insert 1 at the beginning - [1,1,3,3,1]
    *   - Start sum pair by pair from first index [1,1,3,3,1] -> [1,(1+3),3,3,1] -> [1,4,(3+3),3,1] -> [1,4,6,(3+1),1] -> [1,4,6,4,1]
    *
    * Solution 2:
    *   - Instead do computing from end to start, so that you dont have to shift values
    *   - Given row - [1,3,3,1]
    *   - Start sum pair by pair from last index [1,3,3,1] -> [1,3,3,(3+1)] -> [1,3,(3+3),4] -> [1,(3+1),6,4] -> [1,4,6,4]
    *   - Append 1 now -> [1,4,6,4] -> [1,4,6,4,1]
     * */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            for(int j = row.size() - 1; j >= 1 ; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
            row.add(1);
            res.add(new ArrayList<>(row));
        }
        return res;
    }
}
