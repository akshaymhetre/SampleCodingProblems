package com.akshay.learning.DP.recursive;

import java.util.*;
import java.util.stream.Collectors;

/*
* Given a string s and a dictionary of strings wordDict,
* return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.
*
* Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
*
* BFS:
* - Start from index 0 and search if prefix is there in dictionary
* - if prefix found push end (next index of prefix) to queue so that we can later start search from there
* -
* leet code
* */
public class WordBreak {
    public boolean wordBreakIterativeBFS(String s, List<String> wordDict) {
        Set<String> setOfWord = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[s.length()];
        queue.add(0);
        while (!queue.isEmpty()){
            int start = queue.poll();
            if(visited[start]){
                continue;
            }
            for (int end = start+1; end <= s.length() ; end++) {
                String prefix = s.substring(start, end);
                if(setOfWord.contains(prefix)){
                    queue.add(end);
                    if(end == s.length()){
                        return true;
                    }
                }
            }
            visited[start] = true;
        }
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, 0, new HashSet<>(wordDict));
    }

    private boolean wordBreak(String s, int start, Set<String> wordDict) {
        for (int i = start; i < s.length(); i++) {
            String prefix = s.substring(start, i + 1);
            if(wordDict.contains(prefix)){
                if(i+1 != s.length()) {
                    if (wordBreak(s, i + 1, wordDict)) return true;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
