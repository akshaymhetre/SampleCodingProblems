package com.akshay.learning.misc.binarySearch;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShipWithinNDaysTest {
    @Test
    public void shouldWork() {
        assertEquals(15, new ShipWithinNDays().shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5));
    }
}