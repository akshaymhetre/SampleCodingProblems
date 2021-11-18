package com.akshay.learning.misc;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class FindPairWithGivenSum {
    /*
    * nlogn: Sort and keep two poitners low and high
    * */
    public int[] findPairSortMethod(int[] nums, int target){
        Arrays.sort(nums);
        int low = 0;
        int high = nums.length-1;
        while(low < high){
            int sum = nums[low] + nums[high];
            if(sum == target){
               return new int[]{nums[low], nums[high]};
            }
            if(sum < target){
                low++;
            } else {
                high++;
            }
        }
        return new int[]{-1, -1};
    }

    /*
     * o(n) space and time: use hashmap keep check if required difference exists
     * */

    // { 1, 4, -7, 3, 1, 3, 1, -4, -2, -2 }
    // set = 0, 1, 5, -2,
    public int[] findPairHashMapMethod(int[] nums, int target){
        HashMap<Integer, Integer> diffMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = Math.abs(target-nums[i]);
            if(diffMap.containsKey(diff)) return new int[]{diffMap.get(diff), nums[i]};
            else diffMap.put(diff, nums[i]);
        }
        return new int[]{-1, -1};
    }
}
