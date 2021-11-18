package com.akshay.learning.misc.binarySearch;

public class BinarySearch {
    public int binarySearch(int[] arr, int x){
        return binarySearchRecursion(arr, 0, arr.length-1, x);
    }

    public int binarySearchRecursion(int[] arr, int low, int high, int x){
        if(low > high){
            return -1;
        }
        int mid = (high-low)/2;
        if(arr[mid] == x){
            return mid;
        } else if(x < arr[mid]) {
            return binarySearchRecursion(arr, low, mid-1, x);
        } else {
            return binarySearchRecursion(arr, mid+1, high, x);
        }
    }

    public int binarySearchIterative(int[] arr, int x){
        int low = 0, high = arr.length-1;
        while(low <= high){
            int mid = (high-low)/2;
            if(arr[mid] == x){
                return mid;
            } else if(x < arr[mid]) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }
}
