package com.akshay.learning.misc.binarySearch;

import org.junit.Test;

import static org.junit.Assert.*;

public class UpperLowerBoundSortedTest {
    @Test
    public void shouldWork(){
        assertEquals(1, new UpperLowerBoundSorted().getUpperBoundIndex(new int[]{1,3,6,7,9,10}, 2));
        assertEquals(4, new UpperLowerBoundSorted().getUpperBoundIndex(new int[]{1,3,6,7,9,10}, 8));
        assertEquals(5, new UpperLowerBoundSorted().getUpperBoundIndex(new int[]{1,3,6,7,9,10}, 9));

        assertEquals(0, new UpperLowerBoundSorted().getLowerBoundIndex(new int[]{1,3,6,7,9,10}, 2));
        assertEquals(3, new UpperLowerBoundSorted().getLowerBoundIndex(new int[]{1,3,6,7,9,10}, 8));
    }
}