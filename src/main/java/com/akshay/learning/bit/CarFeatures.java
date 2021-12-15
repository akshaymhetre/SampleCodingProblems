package com.akshay.learning.bit;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/*
There are N cars, numbered from 0 to N-1. Each of them has some of the M possible optional features, numbered from 0 to M-1,
for example: voice control, keyless entry, sunroof, blind spot detection, etc.
The features of a car are described as a string of M characters,
where the K-th character being '1' denotes that the car has the K-th possible feature and '0' denotes that it does not.

Two cars are similar if their descriptions differ by at most one feature.
For example: "01101" and "01001" are similar, because they differ only by feature number 2.
On the other hand, "01101" and "11110" are not similar, because they differ in feature numbers 0, 3 and 4.

Each car from the following set is similar to "011": "011", "111", "001", "010".
Notice that cars "011" and "011" are similar as their set of features is exactly the same.

We want to suggest to potential customers alternative cars to the one under consideration.
In order to do that, for each individual car, calculate the number of other cars to which it is
similar (differ from it by at most one feature).

Write a function:

class Solution { public int[] solution(String[] cars); }

that, given an array cars consisting of N strings, returns an array of integers denoting,
for every car in cars, the number of other similar cars.

Examples:

1. Given cars = ["100", "110", "010", "011", "100"],
* the answer should be [2, 3, 2, 1, 2]. Car number 0 ("100") is similar to car number 1 ("110") and also to car number 4 ("100").
* */
public class CarFeatures {
    public int[] diffByOneCount(String[] cars){
        final List<Integer> integers = Arrays.stream(cars).map(s -> Integer.parseInt(s, 2)).collect(Collectors.toList());
        int[] res = new int[cars.length];
        int k = 0;
        for (int i = 0; i < integers.size(); i++) {
            int count = 0;
            for (int j = 0; j < integers.size(); j++) {
                if(i != j && isPossible(integers, i, j)){
                    count++;
                }
            }
            res[k++] = count;
        }
        return res;
    }

    private boolean isPossible(List<Integer> integers, int i, int j) {
        return Objects.equals(integers.get(i), integers.get(j)) || isPowerOf2(integers.get(i) ^ integers.get(j));
    }

    private boolean isPowerOf2(int ans) {
        return ans != 0 && ((ans & (ans-1)) == 0);
    }
}
