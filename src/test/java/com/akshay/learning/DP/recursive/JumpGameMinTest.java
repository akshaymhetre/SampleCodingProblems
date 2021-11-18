package com.akshay.learning.DP.recursive;

import org.junit.Test;

import static org.junit.Assert.*;

public class JumpGameMinTest {
    @Test
    public void shouldWork(){
        JumpGameMin jumpGameMin = new JumpGameMin();
        assertEquals(2,jumpGameMin.jump(new int[]{2,3,0,1,4}));
        assertEquals(1,jumpGameMin.jump(new int[]{1,2}));
        assertEquals(1,jumpGameMin.jump(new int[]{5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5}));
    }
}