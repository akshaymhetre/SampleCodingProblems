package com.akshay.learning.DP.iterative;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxProfitJobSchedulingTest {
    @Test
    public void shouldWork(){
        assertEquals(18,
                new MaxProfitJobScheduling().jobScheduling(
                    new int[]{4,2,4,8,2},
                    new int[]{5,5,5,10,8},
                    new int[]{1,2,8,10,4}
                )
        );
    }
}