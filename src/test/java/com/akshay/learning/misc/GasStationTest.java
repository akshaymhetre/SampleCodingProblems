package com.akshay.learning.misc;

import org.junit.Test;

import static org.junit.Assert.*;

public class GasStationTest {
    @Test
    public void shouldWork(){
        GasStation gasStation = new GasStation();
        assertEquals(3, gasStation.canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
    }

}