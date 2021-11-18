package com.akshay.learning.misc.PrefixSuffixType.prefixSum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EquilibriumIndexTest {
    @Test
    public void shouldWork(){
        assertEquals(3, new EquilibriumIndex().getEquilibriumIndex(new int[]{-7, 1, 5, 2, -4, 3, 0}));
        assertEquals(1, new EquilibriumIndex().getEquilibriumIndex(new int[]{0, 1, 3, -2, -1}));
        assertEquals(-1, new EquilibriumIndex().getEquilibriumIndex(new int[]{1})); // need to validate this cases
        assertEquals(-1, new EquilibriumIndex().getEquilibriumIndex(new int[]{0}));// need to validate this cases
    }
}