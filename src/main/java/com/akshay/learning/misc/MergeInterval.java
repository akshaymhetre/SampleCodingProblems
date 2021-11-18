package com.akshay.learning.misc;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// Merge intervals for given array with start and end timing [(1, 5), (4, 7), (8, 9)]
// output : [(1, 7), (8, 9)]
// Given array may not be in ordered fashion of pairs
// Main logic is:
// - Sort in descending order of start time i.e, higher start time pair will come first [(8, 9), (4, 7), (1, 5)]
// - Iterate pairs one by one and compare prev.start <= curr.end, if yes then only
//     - pick start = min(pair1.start, pair2.start) and end = max(pair1.end, pair2.end)
public class MergeInterval {
    public int solution(int[] A, int[] B) {
        // write your code in Java SE 8
        if(A == null || B == null) return 0;
        if(A.length != B.length || A.length == 0) return 0;

        List<Interval> intervals =
                IntStream.range(0, A.length)
                        .boxed()
                        .map(index -> new Interval(A[index], B[index]))
                        .sorted(Comparator.comparing(Interval::getStart).reversed())
                        .collect(Collectors.toList());


        int index = 0;
        for(int i = 0; i < intervals.size(); i++){

            Interval currentInterval = intervals.get(i);
            if(index != 0 && intervals.get(index - 1).start <= currentInterval.end){
                while(index != 0 && intervals.get(index - 1).start <= currentInterval.end){
                    Interval prevInterval = intervals.get(index - 1);
                    int newEnd = Math.max(prevInterval.end, currentInterval.end);
                    int newStart = Math.min(prevInterval.start, currentInterval.start);
                    prevInterval.start = newStart;
                    prevInterval.end = newEnd;
                    intervals.set(index-1, prevInterval);
                    index--;
                }
            } else {
                intervals.set(index, currentInterval);
            }
            index++;
        }
        return index;
    }

    class Interval{
        public int getStart() {
            return start;
        }

        private int start;
        private int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
