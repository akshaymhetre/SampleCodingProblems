package com.akshay.learning.DP.iterative;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JumpGameMinTest {
    @Test
    public void shouldWork(){
        JumpGameMin jumpGameMin = new JumpGameMin();
        assertEquals(2,jumpGameMin.jumpDP(new int[]{2,3,0,1,4}));
        assertEquals(1,jumpGameMin.jumpDP(new int[]{1,2}));
        assertEquals(5,jumpGameMin.jumpDP(new int[]{5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5}));

        assertEquals(2,jumpGameMin.jumpGreedy(new int[]{2,3,0,1,4}));
        assertEquals(1,jumpGameMin.jumpGreedy(new int[]{1,2}));
        assertEquals(5,jumpGameMin.jumpGreedy(new int[]{5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5}));
    }
}