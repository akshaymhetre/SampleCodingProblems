package com.akshay.learning.misc;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountSmallerToLeftSideTest {
    @Test
    public void shouldWork(){
        assertArrayEquals(new int[]{0, 1, 0, 2, 4, 5, 4}, new CountSmallerToLeftSide().count(new int[]{2,5,1,3,8,14,7}));
    }

}