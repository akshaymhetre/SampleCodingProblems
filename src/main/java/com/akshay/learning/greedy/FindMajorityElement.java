package com.akshay.learning.greedy;

/*
 Find majority element (Boyer–Moore Majority Vote Algorithm)
* Given an integer array containing duplicates, return the majority element if present.
* A majority element appears more than n/2 times, where n is the array size.

For example, the majority element is 2 in array {2, 8, 7, 2, 2, 5, 2, 3, 1, 2, 2}.
* */
public class FindMajorityElement {
    public int findMajorityElement(int[] nums){
        int majorityElement = -1;
        int majorityElementOccurrence = 0;
        for (int num : nums) {
            if (majorityElementOccurrence == 0) {
                majorityElement = num;
                majorityElementOccurrence = 1;
            } else if (majorityElement == num) {
                majorityElementOccurrence++;
            } else {
                majorityElementOccurrence--;
            }
        }
        return majorityElement;
    }
}
