package com.akshay.learning.misc;

import java.util.HashMap;
import java.util.Map;

// Get intersection of two arrays
// Create frequency map with first array
// decrese count by second array
// return element whose freq is positive
public class ArrayIntersectProblem {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int n : nums1){
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }

        for(int n : nums2){
            freqMap.computeIfPresent(n, (key, value) -> value-1);
        }
        return freqMap.entrySet().stream().filter(entry -> entry.getValue() >= 0).map(Map.Entry::getValue).mapToInt(Integer::intValue).toArray();
    }



    public String solution(int A, int B){
        // write your code in Java SE 8
        if(A == 0 && B == 0) return "";
        if(A == 0) {
            return "b" + solution(A, B-1);
        }
        if(B == 0) {
            return "a" + solution(A-1, B);
        }

        String s1 = "a" + solution(A - 1, B);
        String s2 = "b" + solution(A, B - 1);
        String s3 = "ab" + solution(A-1, B - 1);
        String s4 = "ba" + solution(A-1, B - 1);

        if(isValid(s1)) return s1;
        if(isValid(s2)) return s2;
        if(isValid(s3)) return s3;
        if(isValid(s4)) return s4;
        return "";
    }

    boolean isValid(String s) {

        if(s.length() < 3){
            return true;
        }
        int cnt = 1;
        int i = 1;
        while(i < s.length()){
           if(s.charAt(i) == s.charAt(i-1)){
               cnt++;
               if(cnt == 3) return false;
           } else {
               cnt = 1;
           }
           i++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(sol(19));
    }
    public static int sol(int n){

        if(n < 10) {
            return 0;
        }
        int ret = 1;
        while(n > 1){
            n = n/10;
            ret = ret*10;
        }
        return ret;

    }

    public static int sol1(int A, int B){
        int sqrt1 = (int) Math.sqrt(A);
        int sqrt2 = (int) Math.sqrt(B);

        if(sqrt1*(sqrt1+1) < A)
            sqrt1 = sqrt1+1;
        if(sqrt2*(sqrt2+1) <= B)
            sqrt2 = sqrt2+1;
        if(sqrt1 < sqrt2){
            return sqrt2-sqrt1;
        }
        return 0;
    }



}
