package com.akshay.learning.sorting;

public class MergeSort {
    public void sort(int arr[], int n){
        if(n < 2){
            return;
        }
        int mid = n/2;
        int[] left = new int[mid];
        int[] right = new int[n-mid];
        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, n-mid);
        sort(left, mid);
        sort(right, n-mid);
        merge(arr, left, right, mid, n-mid);
    }

    private void merge(int[] arr, int[] left, int[] right, int leftSize, int rightSize) {
        int l = 0, r = 0, i = 0;
        while(l < leftSize && r < rightSize){
            if(left[l] < right[r]){
                arr[i++] = left[l++];
            } else {
                arr[i++] = right[r++];
            }
        }
        while (l < leftSize){
            arr[i++] = left[l++];
        }
        while (r < rightSize){
            arr[i++] = right[r++];
        }
    }
}
