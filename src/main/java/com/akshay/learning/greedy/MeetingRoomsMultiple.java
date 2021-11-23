package com.akshay.learning.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
* Given an array of meeting time intervals consisting of start and end times[[s1,e1],[s2,e2],...](si< ei),
* find the minimum number of conference rooms required.

* Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2

* Example 2:

Input: [[7,10],[2,4]]
Output:1
*
* Logic: As we are considering multiple meeting rooms here
* - Sort intervals by start time
* - Create MIN heap using PriorityQueue with end time (holding meeting room that finishes first)
* - For every interval, compare start time with end time of minimum element from heap (consider that time to finish meeting room)
* - Basically, heap is holding all meeting rooms in finishing order
* */
public class MeetingRoomsMultiple {
    public int minMeetingRooms(int[][] intervals) {
        // sort by start time
        Arrays.sort(intervals, Comparator.comparing(intervalRow -> intervalRow[0]));
        PriorityQueue<Integer> heapByEndTime = new PriorityQueue<>();
        int totalRooms = 0;
        for (int[] interval: intervals) {
            if(heapByEndTime.isEmpty()){
                totalRooms++;
                heapByEndTime.offer(interval[1]); // insert end time
            } else {
                // if curr start interval is greater or equal to min meeting room
                if(interval[0] >= heapByEndTime.peek()){
                    heapByEndTime.poll();
                } else {
                    totalRooms++;
                }
                heapByEndTime.offer(interval[1]);// insert end time
            }
        }
        return totalRooms;
    }
}
