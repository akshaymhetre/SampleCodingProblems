package com.akshay.learning.misc.matrix;

import org.junit.Test;

import static org.junit.Assert.*;

public class SearchMatrixIITest {
    @Test
    public void shouldWork(){
        assertEquals(true, new SearchMatrixII().searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 5));
        assertEquals(false, new SearchMatrixII().searchMatrix(new int[][]{{1,1}}, 2));
    }
}