package com.akshay.learning.sorting;

/*
* In-place merge two sorted arrays
Given two sorted arrays, X[] and Y[] of size m and n each, merge elements of X[] with elements of array Y[]
* by maintaining the sorted order, i.e., fill X[] with the first m smallest elements and fill Y[] with remaining elements.
* Input:

X[] = { 1, 4, 7, 8, 10 }
Y[] = { 2, 3, 9 }

Output:

X[] = { 1, 2, 3, 4, 7 }
Y[] = { 8, 9, 10 }

* Logic:
* -  SWAP X[i], Y[0] if Y[0] < X[i] for all 0 <= i < X.length
* - Position Y[0] correctly, by shiftling all elemnts of Y till they are less than Y[0]
* */
public class InPlaceMergeTwoSorted {
    public void merge(int[] X, int[] Y){
        for (int i = 0; i < X.length; i++) {
            if(X[i] > Y[0]){
                swap(X, Y, i, 0);
                int unsortedFirstElement = Y[0];
                // shift elements until found less than first
                int j ;
                for (j = 1; j < Y.length && Y[j] < unsortedFirstElement; j++) {
                    Y[j-1] = Y[j];
                }
                Y[j-1] = unsortedFirstElement;
            }
        }
    }

    private void swap(int[] X, int[] Y, int m, int n) {
        X[m] =  X[m] ^ Y[n];
        Y[n] =  X[m] ^ Y[n];
        X[m] =  X[m] ^ Y[n];
    }
}
