package com.akshay.learning.misc.slidingWindow;
/*
* Given a string s, find the length of the longest substring without repeating characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
*
* */
public class LongestSubstring {
    /*
    * Best Solution:
    *  Instead of storing frequency like below solution, store the next index after the character found
    *  so that when duplicate found we can directly jump to that index
    *
    * */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // store index of the characters
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(i, index[s.charAt(j)]);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    /*
    * Time complexity : O(2n) = O(n). In the worst case each character will be visited twice by i and j.
    * Logic:
    * Keep left and right pointer
    * Move right pointer till end of string and increment freq of character at right pointer
    * At any point freq at right pointer is greater than one i.e. occurred more than once
    *       - then decrement left counter till right pointer character count is less
    * Keep track of max length got so far ie right-left+1
    * */
    public int lengthOfLongestSubstring2(String s) {
        int[] chars = new int[128];

        int left = 0;
        int right = 0;

        int res = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            chars[r]++;

            while (chars[r] > 1) {
                char l = s.charAt(left);
                chars[l]--;
                left++;
            }

            res = Math.max(res, right - left + 1);

            right++;
        }
        return res;
    }
}
