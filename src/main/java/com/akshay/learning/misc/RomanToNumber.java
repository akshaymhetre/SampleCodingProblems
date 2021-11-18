package com.akshay.learning.misc;

import java.util.HashMap;
import java.util.Map;

public class RomanToNumber {
    /*Roman to integer
     * Just remember special case when the previous roman character is less than next: e.g., IX = 9 (10-1), IV = 4 (5-1)
     *
     * */
    public static Integer decode(String roman) {
        Map<Character, Integer> dict = new HashMap<Character, Integer>(){{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        int res = 0;
        for(int i = 0, n = roman.length(); i < n; i++){
            if(i != n-1 && dict.get(roman.charAt(i)) < dict.get(roman.charAt(i+1))){
                res += dict.get(roman.charAt(i+1)) - dict.get(roman.charAt(i));
                i++;
            } else {
                res += dict.get(roman.charAt(i));
            }
        }

        return res;
    }
}
