package com.akshay.learning.greedy;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobSequencingTest {
    @Test
    public void shouldWork(){
        assertArrayEquals(new int[]{2, 60}, new JobSequencing().JobScheduling(new int[][]{{1,4,20},{2,1,10},{3,1,40},{4,1,30}}, 4));
        assertArrayEquals(new int[]{2, 127},
                new JobSequencing().JobScheduling(new int[][]{{1,2,100},{2,1,19},{3,2,27},{4,1,25},{5,1,15}}, 5));
    }
}