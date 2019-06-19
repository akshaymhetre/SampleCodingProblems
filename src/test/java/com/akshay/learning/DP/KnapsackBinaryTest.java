package com.akshay.learning.DP;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class KnapsackBinaryTest {

    @Test
    public void knapsackRecursionTest() {
        int profits[] = new int[]{600, 100, 120, 90, 90, 90};
        int weights[] = new int[]{10, 20, 30, 10, 10, 10};
        int capacity = 50;
        int totalCount = profits.length;
        Assert.assertEquals(880, (new KnapsackBinary()).knapsackRecursion(capacity, weights, profits, totalCount));

    }

    @Test
    public void knapsackDPTest() {
        int profits[] = new int[]{600, 100, 120, 90, 90, 90};
        int weights[] = new int[]{10, 20, 30, 10, 10, 10};
        int capacity = 50;
        int totalCount = profits.length;
        Assert.assertEquals(880, (new KnapsackBinary()).knapsackDP(capacity, weights, profits, totalCount));

    }
}