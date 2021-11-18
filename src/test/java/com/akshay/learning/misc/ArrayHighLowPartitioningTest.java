package com.akshay.learning.misc;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ArrayHighLowPartitioningTest {

    @Test
    public void testFindArrayHighLowPartitioningIndex() {
        Assert.assertEquals(3, (new ArrayHighLowPartitioning()).findArrayHighLowPartitioningIndex(Arrays.asList(5, -1, 3, 8,6)));
        Assert.assertEquals(1, (new ArrayHighLowPartitioning()).findArrayHighLowPartitioningIndex(Arrays.asList(-8, 0, 5, 88, 4, 2, 10, 8, 78, 21, 2, 33)));
    }
}