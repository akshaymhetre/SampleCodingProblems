package com.akshay.learning.misc;

import org.junit.Test;

import static org.junit.Assert.*;

public class NextGreaterPermutationTest {
    @Test
    public void shouldWork(){
        assertArrayEquals(new int[]{1,3,2}, new NextGreaterPermutation().nextPermutation(new int[]{1,2,3}));
        assertArrayEquals(new int[]{1,2,3}, new NextGreaterPermutation().nextPermutation(new int[]{3,2,1}));
        assertArrayEquals(new int[]{1,5,1}, new NextGreaterPermutation().nextPermutation(new int[]{1,1,5}));
        assertArrayEquals(new int[]{1}, new NextGreaterPermutation().nextPermutation(new int[]{1}));
        assertArrayEquals(new int[]{2,1}, new NextGreaterPermutation().nextPermutation(new int[]{1,2}));
    }

}