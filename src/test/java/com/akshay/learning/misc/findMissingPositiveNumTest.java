package com.akshay.learning.misc;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class findMissingPositiveNumTest {
    @Test
    public void testFindMissingPositive() {
        Assert.assertEquals(1, new FindMissingPositiveNum().findMissing(new int[]{0, 10, 2, -10, -20}, 5));
        Assert.assertEquals(1, new FindMissingPositiveNum().findMissing(new int[]{-1, -3}, 2));
        Assert.assertEquals(3, new FindMissingPositiveNum().findMissing(new int[]{-1, 2, 0, 1, 4, 5}, 5));
        Assert.assertEquals(1, new FindMissingPositiveNum().findMissing(new int[]{0, 2, 5, 4, 3}, 5));
    }

}