package com.akshay.learning.DP.iterative;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaximalSquareTest {
    @Test
    public void shouldWork(){
        assertEquals(4, new MaximalSquare().maximalSquare(new char[][]{
                {'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}
        }));
    }
}