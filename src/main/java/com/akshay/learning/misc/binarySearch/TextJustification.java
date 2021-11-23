package com.akshay.learning.misc.binarySearch;

import java.util.ArrayList;
import java.util.List;

/*
* https://leetcode.com/problems/text-justification/
*
* Example 1:

Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Example 2:

Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
Note that the second line is also left-justified becase it contains only one word.
Example 3:

Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
Output:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]
* */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int i = 0, j = 0;
        List<String> ans = new ArrayList<>();
        while (i < words.length) {
            int totalWordCountSoFar = 0;
            int totalWordCountWithSpaceSoFar = 0;
            while (j < words.length) {
                String word = words[j];
                int wordCount = word.length();
                int wordCountWithSpace = wordCount + 1;
                if (totalWordCountWithSpaceSoFar + wordCountWithSpace > maxWidth+1) {
                    break;
                }
                totalWordCountWithSpaceSoFar += wordCountWithSpace;
                totalWordCountSoFar += wordCount;
                j++;
            }
            if(j == words.length){
                ans.add(getLeftJustified(words, maxWidth, i, j));
            } else {
                ans.add(getFullyJustified(words, totalWordCountSoFar, maxWidth, i, j));
            }
            i = j;
        }
        return ans;
    }

    private String getLeftJustified(String[] words, int maxWidth, int i, int j) {
        StringBuilder sb = new StringBuilder();
        for (int k = i; k < j; k++) {
            sb.append(words[k]);
            sb.append(" ");
        }
        while (sb.length() < maxWidth){
            sb.append(" ");
        }
        return sb.toString();
    }

    private String getFullyJustified(String[] words, int totalWordCountSoFar, int maxWidth, int i, int j) {
        int parts = j-i-1;
        int remSpaces = maxWidth-totalWordCountSoFar;
        int atLeastParts = (parts == 0) ? 0 : remSpaces/parts;
        int extraParts = (parts == 0) ? 0 : remSpaces%parts;
        StringBuilder sb = new StringBuilder();
        for (int k = i; k < j; k++) {
            sb.append(words[k]);
            // distribute spaces only before last word
            if(k < j-1){
                for (int l = 0; l < atLeastParts; l++) sb.append(" ");
                if(extraParts > 0) {
                    sb.append(" ");
                    extraParts--;
                }
            }
        }
        while (sb.length() < maxWidth){
            sb.append(" ");
        }
        return sb.toString();
    }
}
