package com.akshay.learning.misc.binarySearch;

/*
*
* int[] arr = {0,0,0,1,1,1,1};
output : 4
int[] arr = {0,0,1};
output : 1
* */
public class Num1sInsortedbinaryArray {
    public int getCount(int[] arr, int start, int end) {
        if(arr[start] == 1) {
            return end-start+1;
        }
        if(arr[end] == 0) {
            return 0;
        }
        int mid = (start+end)/2;
        int leftCount = getCount(arr, start, mid);
        int rightCount = getCount(arr, mid+1, end);
        return leftCount+rightCount;
    }
}
