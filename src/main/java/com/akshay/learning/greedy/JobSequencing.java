package com.akshay.learning.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/*
Explanation: https://www.youtube.com/watch?v=LjPx4wQaRIs

Given a set of N jobs where each jobi has a deadline and profit associated with it.
Each job takes 1 unit of time to complete and only one job can be scheduled at a time. We earn the profit if and only if the job is completed by its deadline. The task is to find the number of jobs done and the maximum profit.

Note: Jobs will be given in the form (Jobid, Deadline, Profit) associated with that Job.


Example 1:

Input:
N = 4
Jobs = {(1,4,20),(2,1,10),(3,1,40),(4,1,30)}
Output:
2 60
Explanation:
Job1 and Job3 can be done with
maximum profit of 60 (20+40).
Example 2:

Input:
N = 5
Jobs = {(1,2,100),(2,1,19),(3,2,27),
        (4,1,25),(5,1,15)}
Output:
2 127
Explanation:
2 jobs can be done with
maximum profit of 127 (100+27).
 */
public class JobSequencing {
    int[] JobScheduling(int[][] jobs, int n) {
        Job[] arr = new Job[n];
        int i = 0;
        for (int[] job: jobs) {
            arr[i++] = new Job(job);
        }
        // Your code here
        Arrays.sort(arr, Comparator.comparing(Job::getProfit).reversed());

        int maxDeadline = Arrays.stream(arr).max(Comparator.comparing(Job::getDeadline)).get().getDeadline();
        boolean[] isSlotBooked = new boolean[maxDeadline];
        Arrays.fill(isSlotBooked, false);

        int countJobs = 0, jobProfit = 0;
        for (int j = 0; j < n; j++) {
            for (int k = arr[j].getDeadline()-1; k >= 0 ; k--) {
                if(!isSlotBooked[k]){
                    isSlotBooked[k] = true;
                    countJobs++;
                    jobProfit += arr[j].getProfit();
                    break;
                }
            }
        }
        return new int[]{countJobs, jobProfit};
    }

    class Job {
        private int id, deadline, profit;

        public int getId() {
            return id;
        }

        public int getDeadline() {
            return deadline;
        }

        public int getProfit() {
            return profit;
        }

        public Job(int[] row) {
            this.id = row[0];
            this.deadline = row[1];
            this.profit = row[2];
        }
    }


}

