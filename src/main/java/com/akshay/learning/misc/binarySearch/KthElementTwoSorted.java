package com.akshay.learning.misc.binarySearch;

/*
* HARD
* The task is to find the element that would be at the k’th position of the final sorted array.

Video : https://www.youtube.com/watch?v=nv7F4PiLUzo
*
Example 1:

Input:
arr1[] = {2, 3, 6, 7, 9}
arr2[] = {1, 4, 8, 10}
k = 5
Output:
6
Explanation:
The final sorted array would be -
1, 2, 3, 4, 6, 7, 8, 9, 10
The 5th element of this array is 6.

* */
public class KthElementTwoSorted {
    public int kthElement(int arr1[], int arr2[], int m, int n, int k) {
        if(n < m){
            return kthElement(arr2, arr1, n, m, k);
        }
        // pick low and high of smallest array carefully
        // low is minimum element you will pick from arr1, high is maximum
        // Edge case 1: if K > n, that is greater than (arr2) size, then you won't pick low as 0, that is 0 elements from first
        // Edge case 2: if K < m, that is less than (arr1) size, then you won't pick high as m, that is all elements from first
        int low = Math.max(0, k-n);
        int high = Math.min(m, k);
        while(low <= high){
            int cut1 = (low+high) >> 1;
            int cut2 = k-cut1;

            int left1 = (cut1 == 0) ? Integer.MIN_VALUE : arr1[cut1-1];
            int left2 = (cut2 == 0) ? Integer.MIN_VALUE : arr2[cut2-1];
            int right1 = (cut1 == m) ? Integer.MAX_VALUE : arr1[cut1];
            int right2 = (cut2 == n) ? Integer.MAX_VALUE : arr2[cut2];

            if(left1 <= right2 && left2 <= right1){
                return Math.max(left1, left2);
            } else if(left1 > right2){
                low = cut1-1;
            } else {
                high = cut1+1;
            }
        }
        return 1;
    }
}
