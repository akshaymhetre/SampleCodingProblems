package com.akshay.learning.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
* Given a array of integers find the index which  partitions the array to two with high numbers and low numbers.
* For example [5, -1, 3, 8,6] the index 3 will partition the array to [5,-1,3] and [8,6] all the numbers in the second partition are greater than first.
* The solution has to work in O(n).
*
* Step 1: Create max array at each index by iterating from 0 to n e.g., for arr [5, -1, 3, 8,6] => max_array[5, 5, 5, 8, 8]
*
* Step 2: Create min array at each index by iterating from n to 0 e.g., for arr [5, -1, 3, 8,6] => min_array[-1, -1, 3, 6, 6]
*
* Step 3: Find the point where max_array[i] < min_array[i + 1]
*
* */
public class ArrayHighLowPartitioning {
    public int findArrayHighLowPartitioningIndex(List<Integer> arr){
        if(arr == null || arr.isEmpty()){
            return -1;
        }

        List<Integer> maxArr = getMaxArr(arr);

        List<Integer> minArr = getMinArr(arr);

        for(int i = 0 ; i < arr.size()-1 ; i++){
            if(maxArr.get(i) < minArr.get(i+1)){
                return i+1;
            }
        }
        return -1;

    }

    private List<Integer> getMinArr(List<Integer> arr) {
        int[] minArr = new int[arr.size()];
        int tempMin = arr.get(arr.size()-1);
        minArr[arr.size()-1] = tempMin;
        for(int i = arr.size()-2 ; i >= 0 ; i--) {
            if(arr.get(i) < tempMin) {
                tempMin = arr.get(i);
            }
            minArr[i] = tempMin;
        }
        return Arrays.stream(minArr).boxed().collect(Collectors.toList());
    }

    private List<Integer> getMaxArr(List<Integer> arr) {
        List<Integer> maxArr = new ArrayList<>(arr.size());
        int tempMax = arr.get(0);
        maxArr.add(tempMax);
        for(int i = 1 ; i < arr.size() ; i++) {
            if(arr.get(i) > tempMax) {
                tempMax = arr.get(i);
            }
            maxArr.add(tempMax);
        }
        return maxArr;
    }
}
