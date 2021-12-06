package com.akshay.learning.misc;

import java.util.TreeSet;

public class CountSmallerToLeftSide {
    public int[] count(int[] arr){
        int[] res = new int[arr.length];
        final TreeSet<Integer> treeSet = new TreeSet<>();
        int i = 0 ;
        for (int num :
                arr) {
            treeSet.add(num);
            res[i++] = treeSet.headSet(num).size();
        }
        return res;
    }
}
