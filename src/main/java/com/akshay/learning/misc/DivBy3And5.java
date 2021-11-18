package com.akshay.learning.misc;

public class DivBy3And5 {
    // sum of all numbers which are divisible by 3 or 5
    /*
    If the problem is : Find the sum of all the multiples of 3 or 5 below 1000
    Rather than using range/loop based solutions you may wish to leverage more math than brute force.

    There is a simple way to get the sum of multiples of a number, less than a number.

    For instance, the sum of multiples of 3 up to 1000 are: 3 + 6 + 9 + ... + 999 Which can be rewritten as: 3* ( 1 + 2 + 3 + ... + 333)

    There is a simple way to sum up all numbers 1-N:

    Sum(1,N) = N*(N+1)/2
    So a sample function would be

    // sum formula : 1+2+3+...+n = (totalNums*(firstNum+lastnum))/2 = (n*(1+n))/2
    unsigned int unitSum(unsigned int n)
    {
        return (n*(n+1))/2;
    }
    So now getting all multiples of 3 less than 1000 (aka up to and including 999) has been reduced to:

    3*unitSum((int)(999/3))

    You can do the same for multiples of 5:

    5*unitSum((int)(999/5))

    * */
    public int solution(int number) {
        //TODO: Code stuff here
        int sum = 0;
        for(int i = 3; i < number; i++){
            if(i % 3 == 0 || i % 5 == 0){
                sum += i;
            }
        }
        return sum;
    }
}
