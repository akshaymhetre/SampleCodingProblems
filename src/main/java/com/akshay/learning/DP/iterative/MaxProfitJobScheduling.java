package com.akshay.learning.DP.iterative;

import java.util.*;

/*
* We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].

You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that there are no two jobs in the
* subset with overlapping time range.

If you choose a job that ends at time X you will be able to start another job that starts at time X.

Example 1:

Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
Output: 120
Explanation: The subset chosen is the first and fourth job.
Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.

* Example 2:

Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
Output: 150
Explanation: The subset chosen is the first, fourth and fifth job.
Profit obtained 150 = 20 + 70 + 60.

* Example 3:

Input: startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
Output: 6
*
* LOGIC:
* - Understand the recurrence relation:
* MAX_PROFIT_TILL(endTimeJobN) = MAX_PROFIT_TILL(startTimeJobN) + profitOfJobN
*
* - To Solve we first sort the jobs by ending time
* - Use data structure (TreeMap) to store time as key and profit as value also able to find time which is equal to or lesser than given time
* - For example for job: start: 2, end: 5, you will check is there any answer availabble with max profit with
*   job which end before 2 or exactly at 2
* - To easily find out that we will use TreeMap and floorEntry method
* */
public class MaxProfitJobScheduling {
    private class Job {
        private int startTime;
        private int endTime;
        private int profit;

        public Job(int startTime, int endTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Job> jobs = getJobs(startTime, endTime, profit);
        sortJobsByEndTime(jobs); // ascending i.e., increasing order
        // Key = Time (EndTime), Value = Profit
        TreeMap<Integer, Integer> jobsProfitTillEndTime = new TreeMap<>();
        int maxProfit = 0; // keep count of maxProfit so far
        for (Job job : jobs) {
            Map.Entry<Integer, Integer> profitEntryTillStartTimeForCurrentJob = jobsProfitTillEndTime.floorEntry(job.startTime);
            int profitTillStartTimeForCurrentJob = 0;
            // if no element found lesser or equal
            if(profitEntryTillStartTimeForCurrentJob != null){
                profitTillStartTimeForCurrentJob = profitEntryTillStartTimeForCurrentJob.getValue();
            }
            int profitTillEndTimeForCurrentJob = profitTillStartTimeForCurrentJob + job.profit;
            maxProfit = Math.max(maxProfit, profitTillEndTimeForCurrentJob);
            jobsProfitTillEndTime.put(job.endTime, maxProfit); // keep max profit till this endTime
        }
        return maxProfit;
    }

    private void sortJobsByEndTime(List<Job> jobs) {
        jobs.sort(Comparator.comparing(job -> job.endTime));
    }

    private List<Job> getJobs(int[] startTime, int[] endTime, int[] profit) {
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < startTime.length; i++) {
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        }
        return jobs;
    }
}
