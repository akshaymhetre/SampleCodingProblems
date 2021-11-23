package com.akshay.learning.misc.PrefixSuffixType;

import org.junit.Test;

import static org.junit.Assert.*;

public class LargestRectangleHistogramTest {
    @Test
    public void shouldWork(){
        //assertEquals(10, new LargestRectangleHistogram().largestRectangleArea(new int[]{2,1,5,6,2,3}));
        //assertEquals(2, new LargestRectangleHistogram().largestRectangleArea(new int[]{1,1}));
        assertEquals(4, new LargestRectangleHistogram().largestRectangleArea(new int[]{2,3}));
    }
}