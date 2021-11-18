package com.akshay.learning.misc.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/* HARD
https://leetcode.com/problems/minimum-window-substring/
* Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that
* every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

A substring is a contiguous sequence of characters within the string.
* Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
* */
public class MinWindowSubstring {
    public String minWindow(String s, String t) {
        int left = 0, right = 0;
        // freq count for string t
        Map<Character, Integer> subStringCharCount = new HashMap<>();
        for (char c: t.toCharArray()) {
            Integer count = subStringCharCount.getOrDefault(c, 0);
            subStringCharCount.put(c, count+1);
        }
        int required = subStringCharCount.size(); // total unique chars from substring which are required
        // substring formed params
        Map<Character, Integer> formedStringCharCount = new HashMap<>();
        int formed = 0;

        int minWindowLen = -1;
        int windowLeft = 0;

        while (right < s.length()){
            char c = s.charAt(right);
            // Add in map
            Integer count = formedStringCharCount.getOrDefault(c, 0);
            formedStringCharCount.put(c, count+1);

            // If the frequency of the current character added equals to the
            // desired count in t then increment the formed count by 1.
            if (subStringCharCount.containsKey(c) && formedStringCharCount.get(c).intValue() == subStringCharCount.get(c).intValue()) {
                formed++;
            }
            // try to contract window
            while(left <= right && formed == required){
                int currWindowLength = right - left + 1;
                // check if we got new min
                if(minWindowLen == -1 || currWindowLength < minWindowLen){
                    minWindowLen = currWindowLength;
                    windowLeft = left;
                }
                char charl = s.charAt(left);
                // as left is going to move ahead reduce left char count
                formedStringCharCount.put(charl, formedStringCharCount.get(charl)-1);
                // check by reducing count is formed string getting affected
                if(subStringCharCount.containsKey(charl) && formedStringCharCount.get(charl) < subStringCharCount.get(charl)){
                    formed--;
                }
                left++;
            }
            right++;
        }
        return minWindowLen == -1 ? "" : s.substring(windowLeft, windowLeft+minWindowLen);
    }
}
