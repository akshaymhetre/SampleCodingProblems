package com.akshay.learning.misc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
* Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

If multiple answers are possible, return any of them.

It is guaranteed that the length of the answer string is less than 104 for all the given inputs.



Example 1:

Input: numerator = 1, denominator = 2
Output: "0.5"
Example 2:

Input: numerator = 2, denominator = 1
Output: "2"
Example 3:

Input: numerator = 2, denominator = 3
Output: "0.(6)"
Example 4:

Input: numerator = 4, denominator = 333
Output: "0.(012)"
Example 5:

Input: numerator = 1, denominator = 5
Output: "0.2"*/
public class FractionToDecimal {
    /*
    * Lot of cases - Not working for all corner cases
    * Challenging part was to think of all corner cases
    * */
    public String fractionToDecimal(int numerator, int denominator) {
        int pre = numerator / denominator;
        StringBuilder sb = new StringBuilder();
        if(pre == 0 && denominator < 0 && numerator != 0) {
            sb.append("-"+pre);
        } else {
            sb.append(pre);
        }
        denominator = Math.abs(denominator);
        int rem = numerator % denominator;
        rem = Math.abs(rem);

        if (rem == 0) return sb.toString();
        // rem != 0 case
        // map of =>   remainder -> suffix index
        Map<Integer, Integer> visited = new HashMap<>();
        StringBuilder sbSuffix = new StringBuilder();
        while (rem != 0 && !visited.containsKey(rem)) {
            visited.put(rem, sbSuffix.length());
            int newNumerator = rem * 10;
            pre = newNumerator / denominator;
            rem = newNumerator % denominator;
//            if (visited.containsKey(rem)) {
//
//            }
            sbSuffix.append(pre);
            if (visited.containsKey(rem)) {
                int index = visited.get(rem);
                sbSuffix.insert(index, "(");
                sbSuffix.append(")");
            }
        }
        return sb.append(".").append(sbSuffix).toString();
    }

}
