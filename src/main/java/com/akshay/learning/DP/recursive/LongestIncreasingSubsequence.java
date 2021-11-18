package com.akshay.learning.DP.recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
* Input: A = {3, 10, 2, 1, 20}

Output: 3

Explanation: The longest increasing subsequence is {3,10,20}.

Input: A = {10, 2, 5, 3, 7, 101, 18}

Output: 4

Explanation: The longest incresing subsequence is {2,3,7,101} or {2,3,7,18} or {2,5,7,101} or {2,5,7,18}.
* */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] arr){
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, lengthOfLISTillIndex(arr, i));
        }
        return max;
    }

    private int lengthOfLISTillIndex(int[] arr, int index){
        if(index == 0){
            return 1;
        }
        int max = 1;
        for (int i = index-1; i >= 0; i--) {
            if(arr[i] < arr[index]) {
                max = Math.max(max, 1+lengthOfLISTillIndex(arr, i));
            }
        }
        return max;
    }

    public int lengthOfLISDP(int[] arr){
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i ; j++) {
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], 1+dp[j]);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return Arrays.stream(dp).max().getAsInt();
    }

    public int lengthOfLISPatienceSort(int[] arr){
        int[] pileTop = new int[arr.length];
        Arrays.fill(pileTop, Integer.MAX_VALUE);
        int maxIndexUsed = 0;
        for (int ele : arr) {
            int upperBoundIndex = getUpperBoundBinarySearch(pileTop, ele);
            pileTop[upperBoundIndex] = ele;
            maxIndexUsed = Math.max(maxIndexUsed, upperBoundIndex);
        }
        return maxIndexUsed+1;
    }

    private int getUpperBoundBinarySearch(int[] arr, int x) {
        int low = 0, high = arr.length-1;
        while (low <= high){
            int mid = (low+high) >> 1;
            if(arr[mid] <= x){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return low;
    }

    //https://leetcode.com/problems/longest-increasing-subsequence/discuss/1326308
    public int lengthOfLISNew(int[] nums) {
        List<Integer> piles = new ArrayList<>(nums.length);
        for (int num : nums) {
            // This return lowerBound if num not found
            int pile = Collections.binarySearch(piles, num);
            // returns -1 if element not found or given array size is zero
            if (pile < 0) pile = ~pile; // set pile to zero if -1
            if (pile == piles.size()) {
                piles.add(num);
            } else {
                piles.set(pile, num);
            }
        }
        System.out.println(piles);
        return piles.size();
    }

    //https://leetcode.com/problems/longest-increasing-subsequence/discuss/1326308
    static class PrintLIS {
        // keep prev pointer pointing to last index element
        public List<Integer> lengthOfLIS(int[] nums) {
            List<Node> piles = new ArrayList<>(nums.length);
            for (int num : nums) {
                Node node = new Node(num);
                int pile = Collections.binarySearch(piles, node);
                if (pile < 0) pile = ~pile;

                if (pile != 0) {
                    node.prev = piles.get(pile - 1);
                }

                if (pile == piles.size()) {
                    piles.add(node);
                } else {
                    piles.set(pile, node);
                }
            }
            return extractLIS(piles);
        }

        private List<Integer> extractLIS(List<Node> piles) {
            List<Integer> result = new ArrayList<>(piles.size());
            for (Node curr = piles.isEmpty() ? null : piles.get(piles.size() - 1); curr != null; curr = curr.prev) {
                result.add(curr.val);
            }
            Collections.reverse(result);
            return result;
        }

        private static class Node implements Comparable<Node> {
            int val;
            Node prev;

            public Node(int val) {
                this.val = val;
            }

            @Override
            public int compareTo(Node that) {
                return Integer.compare(this.val, that.val);
            }
        }
    }
}
