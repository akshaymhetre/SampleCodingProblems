package com.akshay.learning.graphType;

import org.junit.Test;

import static org.junit.Assert.*;

public class CourseScheduleTest {
    @Test
    public void shouldWork(){
        assertTrue(new CourseSchedule().canFinish(2, new int[][]{{1, 0}}));
        //assertTrue(new CourseSchedule().canFinish(1, new int[][]{}));
        //assertTrue(new CourseSchedule().canFinish(2, new int[][]{{0, 1}}));
    }
}