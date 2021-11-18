package com.akshay.learning.misc.binarySearch;

/* HARD
* Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

Follow up:
The overall run time complexity should be O(log (m+n)).
*
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2
*
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

* Video: https://www.youtube.com/watch?v=NTop3VTjmxk
* Blog: https://redquark.org/leetcode/0004-median-of-two-sorted-arrays/
*
* */
public class MedianTwoSortedArr {
    public double median(int[] arr1, int[] arr2){
        if (arr1.length > arr2.length) {
            return median(arr2, arr1);
        }
        int m = arr1.length;
        int n = arr2.length;

        /*
        Take pointers on partition instead of numbers, this is also called parition index
        *       0   1   2   3   4   5
        *       | 8 | 7 | 6 | 5 | 4 |
        That's why below start is 0 and end is m.
        * */
        int start = 0, end = m;
        int total = m+n;
        while (start <= end){ // Notice end is equal to length here, as partition can be possible at that part
            int cut1 = (start+end) >> 1; // same as (start+end)/2
            int cut2 = ((total+1)/2)-cut1; //half of total - first cut, this (total+1)/2 handles odd and even case as well
            int maxLeft1 = (cut1 == 0) ? Integer.MIN_VALUE: arr1[cut1-1]; // number before partition
            int maxLeft2 = (cut2 == 0) ? Integer.MIN_VALUE: arr2[cut2-1];

            int minRight1 = (cut1 == m) ? Integer.MAX_VALUE: arr1[cut1];
            int minRight2 = (cut2 == n) ? Integer.MAX_VALUE: arr2[cut2];

            if(maxLeft1 <= minRight2 && maxLeft2 <= minRight1){
                if((m+n)%2 == 0){
                    return (Math.max(maxLeft1, maxLeft2)+Math.min(minRight1, minRight2))/2.0;
                } else {
                    return Math.max(maxLeft1, maxLeft2);
                }
            } else if(maxLeft1 > minRight2){
                end = cut1-1;
            } else { // maxLeft2 > minRight1
                start = cut1+1;
            }
        }
        return 0.0;
    }
}
