package com.akshay.learning.misc.binarySearch;

// Java program to find first and last occurrence of
// an elements in given sorted array
/*
*
* Input : arr[] = {1, 3, 5, 5, 5, 5, 67, 123, 125}
        x = 5
Output : First Occurrence = 2
         Last Occurrence = 5

Input : arr[] = {1, 3, 5, 5, 5, 5, 7, 123, 125 }
        x = 7
Output : First Occurrence = 6
         Last Occurrence = 6
         * */
public class FindFirstAndLastOccurrenceSorted {
    public Tuple<Integer, Integer> findFirstAndLast(int arr[], int x){
        return Tuple.of(getFirstOccurrence(arr, x), getLastOccurrence(arr, x));
    }

    private int getFirstOccurrence(int[] arr, int x) {
        int low = 0, high = arr.length - 1, res = -1;
        while(low <= high){
            int mid = (low+high)/2;
            if(arr[mid] > x) {
                high = mid - 1;
            } else if(arr[mid] < x) {
                low = mid + 1;
            } else {
                res = mid;
                high = mid-1;
            }
        }
        return res;
    }

    private int getLastOccurrence(int[] arr, int x) {
        int low = 0, high = arr.length - 1, res = -1;
        while(low <= high){
            int mid = (low+high)/2;
            if(arr[mid] > x) {
                high = mid - 1;
            } else if(arr[mid] < x) {
                low = mid + 1;
            } else {
                res = mid;
                low = mid+1;
            }
        }
        return res;
    }

    static class Tuple<A, B> {
        private final A a;
        private final B b;

        public Tuple(A a, B b) {
            this.a = a;
            this.b = b;
        }

        public static <A, B> Tuple<A, B> of(A a, B b) {
            return new Tuple<>(a, b);
        }

        public A getA() {
            return a;
        }

        public B getB() {
            return b;
        }
    }
}
