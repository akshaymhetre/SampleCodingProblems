package com.akshay.learning.misc;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupAnagram {
    /*
    * Logic:
    * - Calculate frequency of all characters for each word
    * - Concat freq and form a key - a-1, b-0, c-3,...,z-0 -> key will be -> 1#0#3# ..... 0#
    * - Create map and add all words with same key in same bucket
    * - All anagrams are grouped now
    * */
    public List<List<String>> solution(String[] words){
        Map<String, List<String>> map = new HashMap<>();
        int[] charCount = new int[26];
        for(String word : words){
            Arrays.fill(charCount, 0);
            for(char c : word.toCharArray()) charCount[c-'a']++;

            //String key = Arrays.stream(charCount).mapToObj(Integer::toString).collect(Collectors.joining("#"));
            StringBuilder stringBuilder = new StringBuilder();
            for (int j : charCount) {
                stringBuilder.append(j);
                stringBuilder.append("#");
            }
            String key = stringBuilder.toString();
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(word);
        }
        return new ArrayList<>(map.values());
    }

    public int[] intersection(int[] a, int[] b){
        Set<Integer> integers = Arrays.stream(a).boxed().collect(Collectors.toSet());
        integers.retainAll(Arrays.stream(b).boxed().collect(Collectors.toSet()));
        return integers.stream().mapToInt(i -> i).toArray();
    }

    public int maxProfit(int[] prices) {
        int minNum = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int price: prices){
            if(price < minNum){
                minNum = price;
            }
            maxProfit = Math.max(maxProfit, price-minNum);
        }
        return maxProfit;
    }



}
