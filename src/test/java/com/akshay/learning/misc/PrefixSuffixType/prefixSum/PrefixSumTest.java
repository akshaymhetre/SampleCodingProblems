package com.akshay.learning.misc.PrefixSuffixType.prefixSum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrefixSumTest {
    @Test
    public void shouldWork(){
        assertEquals(8, new PrefixSum().getSumWithinRange(new int[]{3,5,1,-1,5,-4}, 0, 3));
        assertEquals(9, new PrefixSum().getSumWithinRange(new int[]{3,5,1,-1,5,-4}, 0, 2));
        assertEquals(6, new PrefixSum().getSumWithinRange(new int[]{3,5,1,-1,5,-4}, 1, 2));
    }
}