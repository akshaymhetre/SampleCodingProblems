package com.akshay.learning.misc.sequence;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestIncreasingConsecutiveSubsequenceTest {
    @Test
    public void shouldWork(){
        assertEquals(6, new LongestIncreasingConsecutiveSubsequence().lengthOfLICS(new int[]{3, 10, 3, 11, 4, 5, 6, 7, 8, 12}));
        assertEquals(5, new LongestIncreasingConsecutiveSubsequence().lengthOfLICS(new int[]{6, 7, 8, 3, 4, 5, 9, 10}));
    }
}