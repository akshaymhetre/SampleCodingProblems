package com.akshay.learning.graphType;

import java.util.*;
import java.util.stream.Collectors;

/*
https://leetcode.com/problems/course-schedule/
https://www.youtube.com/watch?v=2l22FRtU45M

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. Y

ou are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.



Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

Logic: Its like detecting cycle in directed graph
- each course is dependent on each other
- keep array of indegree[n] = total incoming edges to vertex n (in our case total courses should be competed before course n)
- create zeroDegree SET with all vertices with no incoming edges
- pick one vertex or course from zeroDegree mark it complete, remove all outgoing edges,
    this means decrement all indgree count for the courses which were dependent on this picked course
    - while doing this if you find any vertex with zero indegree add it to zeroDegree
- Do this until zeroDegree set finishes
- if we still have any course with indgree greater than zero we have loop

* */
public class CourseSchedule {
    // int[1] should be completed first, int[0] depends on int[1], so graph structure is : int[1] -> int[0], mean int[1] should be completed first and then go to int[0]
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Arrays.fill(inDegree, 0);
        // e.g., [1, 0] => int[1] -> int[0],  for this example: Course-0 --(ifCompletedThen)--> Course-1
        //[1, 0]
        // calculate in-degree
        for (int[] prerequisite:  prerequisites) {
            int dependentCourse = prerequisite[0];
            inDegree[dependentCourse]++;
        }
        //courses with no dependency
        Set<Integer> zeroDegreeCourses = new HashSet<>();
        for (int courseNum = 0; courseNum < numCourses; courseNum++) {
            int degree = inDegree[courseNum];
            if (degree == 0) {
                zeroDegreeCourses.add(courseNum);
            }
        }
        if(zeroDegreeCourses.isEmpty()) return false;
        while (!zeroDegreeCourses.isEmpty()){
            Iterator<Integer> iterator = zeroDegreeCourses.iterator();
            Integer courseWithZeroDegree = iterator.next();
            zeroDegreeCourses.remove(courseWithZeroDegree);
            // remove edge going outwards
            for (int[] prerequisite:  prerequisites) {
                int dependentCourse = prerequisite[1];
                int courseNeedDependency = prerequisite[0];
                // remove edge going outwards
                // that is reduced degree of courseNeedDependency, if the dependent course is courseWithZeroDegree
                if(dependentCourse == courseWithZeroDegree){
                    inDegree[courseNeedDependency]--;
                    //in case 0 dep required by courseNeedDependency
                    if(inDegree[courseNeedDependency] == 0){
                        zeroDegreeCourses.add(courseNeedDependency);
                    }
                }
            }
        }
        return Arrays.stream(inDegree).noneMatch(degree -> degree != 0);
    }
}
