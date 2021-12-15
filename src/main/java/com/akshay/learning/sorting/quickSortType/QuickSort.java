package com.akshay.learning.sorting.quickSortType;

public class QuickSort {
    /*
    * - Pass arr, low=0 and high=arr.length-1 index of arr
    * - find partition index
    *       - pick pivot as last element
    *       - assume lowest element index is out of arr i.e low-1
    *       - for all elements other than pivot check if elemnt is lower or equal than pivot i++ and swap(i,j)
    *       - at the end swap(i+1, j)
    * - repeat for left and right partition
    * */
    // low is 0 and high is arr.length-1
    public void sort(int arr[], int low, int high){
        if(low < high){
            int partition = partition(arr, low, high);
            sort(arr, low, partition-1);
            sort(arr, partition+1, high);
        }
    }

    // we are just making sure all elements less than pivot are on the left side
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low-1; // smallest element, append all small element after this
        // compare elements with pivot, if found smaller than pivot then swap it next to smallest element
        for(int j = low ; j < high; j++){
            if(arr[j] <= pivot){
                i++;
                swap(arr, i, j);
            }
        }
        // at the end swap pivot with element next to last smallest i.e, i+1
        swap(arr, i+1, high);
        return i+1; // return the new pivot position
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
