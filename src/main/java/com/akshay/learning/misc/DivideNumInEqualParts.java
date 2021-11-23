package com.akshay.learning.misc;

import java.util.Arrays;

public class DivideNumInEqualParts {
    int[] dividePartsSimple(int num, int parts){
        int res = num / parts;
        int rem = num % parts;
        int[] resultArr = new int[parts];
        if(rem == 0){
            Arrays.fill(resultArr, res);
            return resultArr;
        } else {
            int partToFillWithRes = parts- rem;
            for (int i = 0; i < partToFillWithRes; i++) {
                resultArr[i] = res;
            }
            // fill remaining part with value greater than one from previous
            for (int i = partToFillWithRes; i < parts; i++) {
                resultArr[i] = res+1;
            }
        }
        return resultArr;
    }
    /*
    * Divide number in equal parts:
    * 2 cases:
    * case 1: num = 10, parts = 5, remainder will be 0 so can be divided into 5 parts with value 2
    * case 2: num = 10, parts = 3, remainder is not 0, it is 1, that means one place will be empty and other place will have value = 10/3, parts => 3, 3, _
    * Sum of picked numbers is 6 and As 10 sum is not achived yet, Call funciton recursively to achive sum = 4 with part remaining 1 :  divideParts(4, 1)
    * 3-1 = 2
    * */
    int[] divideParts(int num, int parts){
        int res = num / parts;
        int rem = num % parts;
        int[] resultArr = new int[parts];
        if(rem == 0){
            Arrays.fill(resultArr, res);
            return resultArr;
        } else {
            int partToFillWithRes = parts- rem; // 2  10/3 = 3   3 3 4   10-(2*3) = 4
            for (int i = 0; i < partToFillWithRes; i++) {
                resultArr[i] = res;
            }
            int[] remainingParts = divideParts(num-(partToFillWithRes*res), rem);
            System.arraycopy(remainingParts, 0, resultArr, partToFillWithRes, remainingParts.length);
        }
        return resultArr;
    }
}
