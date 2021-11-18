package com.akshay.learning.misc;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayIntersectProblemTest {

    @Test
    public void intersect() {
        Assert.assertArrayEquals(new int[]{2,2}, new ArrayIntersectProblem().intersect(new int[]{1, 2, 2, 1}, new int[]{2,2}));
    }


    @Test
    public void mergeIntervals() {
        Assert.assertEquals(5, new MergeInterval().solution(new int[]{1, 12, 42, 70, 36, -4, 43, 15}, new int[]{5, 15, 44, 72, 36, 2, 69, 24}));
    }

    @Test
    public void mergeIntervals1() {
        Assert.assertEquals("", new ArrayIntersectProblem().solution(5,3));
    }
}