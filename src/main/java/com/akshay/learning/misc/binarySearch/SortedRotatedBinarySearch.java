package com.akshay.learning.misc.binarySearch;

public class SortedRotatedBinarySearch {
    public int search(int arr[], int x) {
        int low = 0, high = arr.length-1, res = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(arr[mid] == x) {
                return mid;
            }
            if(arr[low] <= arr[mid]){ // if left array is sorted
                if(arr[low] >= x && x < arr[mid]) // x is between low and mid
                    high = mid-1;
                else
                    low = mid + 1;

            } else { // if right array is sorted
                if(arr[high] <= x && x > arr[mid]) // x is between high and mid
                    low = mid + 1;
                else
                    high = mid - 1;
            }

        }
        return res;
    }
}
