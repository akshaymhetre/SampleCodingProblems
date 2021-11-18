package com.akshay.learning.misc;

/*
* Right rotate an array `k` times
   Input: arr= { 1, 2, 3, 4, 5, 6, 7 }, k =3
 * Output:  {5, 6, 7, 1, 2, 3, 4 }
 * Logic:
 *   - Reverse right side k elements as we are rotating right, arr= { 1, 2, 3, 4, 7, 6, 5 }
 *   - Reverse remaining k-1 elements from left, arr= { 4, 3, 2, 1, 7, 6, 5 }
 *   - Reverse entirely, arr= { 5, 6, 7, 1, 2, 3, 4 }
 * */
public class RotateArray {
    public int[] rotateArr(int[] arr, int k){
        int length = arr.length;

        reverseArrBetween(arr, 0, length-k-1);
        reverseArrBetween(arr, length-k, length-1);
        reverseArrBetween(arr, 0, length-1);
        return arr;
    }

    private void reverseArrBetween(int[] arr, int start, int end){
        while(start < end){
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] arr, int start, int end) {
        arr[start] = arr[start] ^ arr[end];
        arr[end] = arr[start] ^ arr[end];
        arr[start] = arr[start] ^ arr[end];
    }
}
