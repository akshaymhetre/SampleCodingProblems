package com.akshay.learning.bit;

import org.junit.Test;

import static org.junit.Assert.*;

public class CarFeaturesTest {
    @Test
    public void shouldWork(){
        assertArrayEquals(new int[]{2,3,2,1,2}, new CarFeatures().diffByOneCount(new String[]{"100", "110", "010", "011", "100"}));
    }
}