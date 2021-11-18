package com.akshay.learning.DP.recursive;

public class Fibonacci {
    public int fibRec(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        return fibRec(n-1)+fibRec(n-2);
    }

    public int fibTailRec(int n){
        return _fibTailRec(n, 0, 1);
    }

    public int _fibTailRec(int n, int first, int second){
        if(n == 0) return first;
        if(n == 1) return second;
        return _fibTailRec(n-1, second, first+second);
    }

    public int fibIterative(int n){
        int first = 0;
        int second = 1;
        while(n > 1){
            int temp = first;
            first = second;
            second += temp;
            n--;
        }
        if(n == 0) return first;
        else return second;
    }
}
