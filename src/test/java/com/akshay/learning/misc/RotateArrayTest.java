package com.akshay.learning.misc;

import org.junit.Test;

import static org.junit.Assert.*;

public class RotateArrayTest {
    @Test
    public void shouldWork(){
        assertArrayEquals(new int[]{ 5, 6, 7, 1, 2, 3, 4 }, new RotateArray().rotateArr(new int[]{ 1, 2, 3, 4, 5, 6, 7 }, 3));
    }
}