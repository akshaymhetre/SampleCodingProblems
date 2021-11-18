package com.akshay.learning.sorting.quickSortType;

/*
* Given a binary array, sort it in linear time and constant space. The output should print all zeroes, followed by all ones.

For example,

Input:  { 1, 0, 1, 0, 1, 0, 0, 1 }

Output: { 0, 0, 0, 0, 1, 1, 1, 1 }
* */
public class SortBinaryArray {
    public void sort(int[] A){
        int pivot = 1;
        int smallestIndex = -1; // zero position index
        for (int i = 0; i < A.length; i++) {
            if(A[i] < pivot){
                smallestIndex++;
                swap(A, smallestIndex, i);
            }
        }
    }

    private void swap(int[] a, int smallestIndex, int i) {
        a[smallestIndex] =  a[smallestIndex] ^ a[i];
        a[i] =  a[smallestIndex] ^ a[i];
        a[smallestIndex] =  a[smallestIndex] ^ a[i];
    }
}
