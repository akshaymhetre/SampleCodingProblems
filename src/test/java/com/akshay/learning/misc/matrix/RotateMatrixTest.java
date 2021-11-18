package com.akshay.learning.misc.matrix;

import org.junit.Test;

import static org.junit.Assert.*;

public class RotateMatrixTest {
    @Test
    public void shouldWork(){
        //assertArrayEquals(new int[][]{{7,4,1},{8,5,2},{9,6,3}}, new RotateMatrix().rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        assertArrayEquals(new int[][]{{15,13,2,5},{14,3,4,1},{12,6,8,9},{16,7,10,11}}, new RotateMatrix().rotate(new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}}));
    }
}