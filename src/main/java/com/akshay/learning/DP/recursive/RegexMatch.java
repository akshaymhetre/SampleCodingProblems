package com.akshay.learning.DP.recursive;

/*
* Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).
*
* Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
*
* Example 2:

Input: s = "aa", p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input: s = "ab", p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
*
* */
public class RegexMatch {
    /*
      Keep two pointers i & j, 'i' on given string and 'j' on pattern
    * Case1: If no special character in pattern then its straight forward str[i++] == p[j++]
    * Case 2: If '.' then match str[i++] == p[j++]
      Case 3: If '*' then we have two choices either to take
                choice 1: Do not consider character and move j pointer by j+2 (beyond '*' character), i pointer will remain same
                choice 2: If only chracters at i and j matching then, move i pointer bye i+1, but not j pointer

      Consider all cases, basecases will be:
      if i and j both reach at end or beyond then there is match
      if only j pointer reach at end but not i pointer, then that is false
      if i pointer reach at end or beyond but not j then that is still fine, s= a, a*b* => this is still match

    * */
    public boolean isMatch(String s, String p) {
        return _isMatch(s, p, 0, 0);
    }

    private boolean _isMatch(String s, String p, int i, int j) {
        if(i >= s.length() && j >= p.length()){
            return true;
        }
        if(j >= p.length()){
            return false;
        }
        boolean firstMatch = false;
        if(i < s.length())
            firstMatch = s.charAt(i) == p.charAt(j) || p.charAt(j) == '.';
        if((j+1) < p.length() && p.charAt(j+1) == '*'){
            return _isMatch(s, p, i, j+2) || (firstMatch && _isMatch(s, p, i+1, j));
        }
        if(firstMatch)
            return _isMatch(s, p, i+1, j+1);
        return false;
    }
}
