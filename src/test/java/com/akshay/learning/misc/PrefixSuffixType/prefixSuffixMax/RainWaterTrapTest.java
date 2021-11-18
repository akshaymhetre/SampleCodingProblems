package com.akshay.learning.misc.PrefixSuffixType.prefixSuffixMax;

import org.junit.Test;

import static org.junit.Assert.*;

public class RainWaterTrapTest {
    @Test
    public void shouldWork(){
        assertEquals(6, new RainWaterTrap().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

}