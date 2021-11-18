package com.akshay.learning.sorting.quickSortType;

/*
* Given an array containing only 0’s, 1’s, and 2’s, sort it in linear time and using constant space.
Dutch Flag Problem
*
For example,

Input:  { 0, 1, 2, 2, 1, 0, 0, 2, 0, 1, 1, 0 }

Output: { 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2 }
* */
public class SortArrWithZeroOneAndTwo {
    public void threeWayPartition(int[] A){
        int pivot = 1;
        int start = 0; // zero position index
        int mid = 0; // one position index
        int end = A.length - 1; // two position index
        while (mid <= end) {
            if(A[mid] < pivot){ // if A[mid] is 0, swap to start and increment start and mid
                swap(A, start, mid);
                start++;
                mid++;
            } else if(A[mid] > pivot){ // If A[mid] is 2, decrement end
                swap(A, mid, end);
                end--;
            }  else { // If A[mid] is 1, increment mid
                mid++;
            }
        }
    }

    public void threeWayPartition1(int[] A){
        int start = 0; // zero position index
        int mid = 0; // one position index
        int end = A.length - 1; // two position index
        while (mid <= end) {
            switch(A[mid]){ // if A[mid] is 0, swap to start and increment start and mid

                case 0:
                    swap(A, start, mid);
                    start++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(A, mid, end);
                    end--;
                    break;
            }
        }
    }

    private void swap(int[] a, int smallestIndex, int i) {
        a[smallestIndex] =  a[smallestIndex] ^ a[i];
        a[i] =  a[smallestIndex] ^ a[i];
        a[smallestIndex] =  a[smallestIndex] ^ a[i];
    }
}
