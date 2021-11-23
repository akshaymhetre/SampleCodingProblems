package com.akshay.learning.misc;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class DivideNumInEqualPartsTest {
    @Test
    public void shouldWork(){
        assertArrayEquals(new int[]{2,2,2,2,2}, new DivideNumInEqualParts().dividePartsSimple(10, 5));
        assertArrayEquals(new int[]{3,3,3,3,4,4}, new DivideNumInEqualParts().dividePartsSimple(20, 6));
        int[] divide = new DivideNumInEqualParts().dividePartsSimple(100, 21);
        Arrays.stream(divide).forEach(System.out::println);
        assertArrayEquals(new int[]{2,2,2,3,3,3,3,3}, new DivideNumInEqualParts().dividePartsSimple(21, 8));
    }
}