package com.akshay.learning.misc.binarySearch;

import java.util.Arrays;

/* HARD:

similar problem on Leetcode -
1482 Minimum Number of Days to Make m Bouquets
1283 Find the Smallest Divisor Given a Threshold
1231 Divide Chocolate
1011 Capacity To Ship Packages In N Days
875 Koko Eating Bananas
Minimize
774 Max Distance to Gas Station
410 Split Array Largest Sum
1986. Minimum Number of Work Sessions to Finish the Tasks


* Given an array of integers A of size N and an integer B.
College library has N bags,the ith book has A[i] number of pages.

You have to allocate books to B number of students so that maximum number of pages alloted to a student is minimum.

A book will be allocated to exactly one student.
Each student has to be allocated at least one book.
Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.
Calculate and return that minimum possible number.

NOTE: Return -1 if a valid assignment is not possible.

Input Format

The first argument given is the integer array A.
The second argument given is the integer B.
Output Format

Return that minimum possible number
Constraints

1 <= N <= 10^5
1 <= A[i] <= 10^5
For Example

Input 1:
    A = [12, 34, 67, 90]
    B = 2
Output 1:
    113
Explanation 1:
    There are 2 number of students. Books can be distributed in following fashion :
        1) [12] and [34, 67, 90]
        Max number of pages is allocated to student 2 with 34 + 67 + 90 = 191 pages
        2) [12, 34] and [67, 90]
        Max number of pages is allocated to student 2 with 67 + 90 = 157 pages
        3) [12, 34, 67] and [90]
        Max number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages

        Of the 3 cases, Option 3 has the minimum pages = 113.

    100*/
public class AllocateBooks {
    public int books(int[] A, int B) {
        if(B > A.length) return -1;
        int low = A[0];
        int high = Arrays.stream(A).sum();
        int ans = -1;
        while (low <= high){
            int mid = (low+high) >> 1;
            if(isPossible(A, B, mid)){
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }

    private boolean isPossible(int[] a, int totalStudents, int totalPages) {
        int studentAllocated = 0;
        int pagesAllocated = 0;
        for (int i = 0; i < a.length; i++) {
            if(pagesAllocated+a[i] > totalPages){
                studentAllocated++;
                pagesAllocated = a[i]; //reset to new element for next student
                if(pagesAllocated > totalPages) return false;
            } else {
                pagesAllocated += a[i];
            }
        }
        if(studentAllocated < totalStudents) return true; // ****IMPORTANT*****
        return false;
    }
}
