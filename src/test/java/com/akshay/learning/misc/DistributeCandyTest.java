package com.akshay.learning.misc;

import com.akshay.learning.misc.PrefixSuffixType.DistributeCandy;
import org.junit.Test;

import static org.junit.Assert.*;

public class DistributeCandyTest {
    @Test
    public void shouldWork(){
        assertEquals(3, new DistributeCandy().minCandy(new int[]{1, 2}));
        assertEquals(7, new DistributeCandy().minCandy(new int[]{1, 5, 2, 1}));
    }
}