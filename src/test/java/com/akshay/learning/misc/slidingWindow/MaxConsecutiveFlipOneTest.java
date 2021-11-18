package com.akshay.learning.misc.slidingWindow;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxConsecutiveFlipOneTest {
    @Test
    public void shouldWork(){
        MaxConsecutiveFlipOne maxConsecutiveFlipOne = new MaxConsecutiveFlipOne();
        assertEquals(6, maxConsecutiveFlipOne.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
        assertEquals(6, maxConsecutiveFlipOne.longestOnes(new int[]{1,1,1,0,1,0,0,1,1,1,0}, 2));
        assertEquals(10, maxConsecutiveFlipOne.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
        assertEquals(3, maxConsecutiveFlipOne.longestOnes(new int[]{0,0,1,1,1,0,0}, 0));
    }

}