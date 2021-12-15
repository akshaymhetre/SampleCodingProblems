package com.akshay.learning.misc.slidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/*
https://www.youtube.com/watch?v=CZQGRp93K4k
* HARD:
* You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array
* to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation:
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

 Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length

* */
public class MaxSlidingWindow {
    /*
    * Logic:
    *   - Use Deque so that you can add and remove element from front
    *   - Keep elements in decreasing order, for example in above given input, if number 1 is added as max to front,
    *     and if 3 number comes, there is no use of keeping 1, as it will never be max, even though window moves ahead
    *   - At each window print/take out first element
    *   - Once window goes out of sight for first element remove that element as its not needed
    * */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] r = new int[n-k+1];
        int ri = 0;
        // store index
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // remove numbers out of range k
            if (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            // adding index
            deque.offer(i);
            if (i >= k - 1 && !deque.isEmpty()) {
                r[ri++] = nums[deque.peek()];
            }
        }
        return r;
    }
}
