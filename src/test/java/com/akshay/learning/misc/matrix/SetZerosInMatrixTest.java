package com.akshay.learning.misc.matrix;

import org.junit.Test;

import static org.junit.Assert.*;

public class SetZerosInMatrixTest {
    @Test
    public void shouldWork(){
//        assertArrayEquals(new int[][]{{1,0,1},{0,0,0},{1,0,1}},
//                new SetZerosInMatrix().setZeroes(new int[][]{{1,1,1},{1,0,1},{1,1,1}}));

        assertArrayEquals(new int[][]{{0,0,0,0},{0,4,5,0},{0,3,1,0}},
                new SetZerosInMatrix().setZeroes(new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}}));
    }
}
