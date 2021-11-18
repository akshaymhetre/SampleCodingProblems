package com.akshay.learning.misc;

/*
  There are multiple solutions but following is
* Interesting Solution with O(n) time and O(1) space:
* - Traverse chars from left to right
* - Increment left if '(' found or right if ')' found
* - Every time left and right count matches set max as 2*right (or 2*left)
 - At any point right > left then set left, right counters again to 0
*
*
* - Do similar procedure by traversing chars from right to left
*
* We are doing this as we might miss case like "((()", where answer is 1 but first traversal will give 0.
* */
public class LongestValidParenthesis {
    public int longestValidParenthesis(String str){
        int left = 0;
        int right = 0;
        int max = 0;
        for(char c : str.toCharArray()){
            if(c == '(') left++; else right++;
            if(left == right){
                max = Math.max(max, 2*right);
            }
            if(right > left){
                left = right = 0;
            }
        }
        left = right = 0;
        for(int i = str.length()-1 ; i >=0 ; i++){

            if(str.charAt(i) == ')') right++; else left++;
            if(left == right){
                max = Math.max(max, 2*left);
            }
            if(left> right){
                left = right = 0;
            }
        }
        return max;
    }
}
