package com.akshay.learning.DP.recursive;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestIncreasingSubsequenceTest {
    @Test
    public void shouldWork(){
        assertEquals(3, new LongestIncreasingSubsequence().lengthOfLIS(new int[]{3, 10, 2, 1, 20}));
        assertEquals(4, new LongestIncreasingSubsequence().lengthOfLIS(new int[]{10, 2, 5, 3, 7, 101, 18}));

        assertEquals(3, new LongestIncreasingSubsequence().lengthOfLISDP(new int[]{3, 10, 2, 1, 20}));
        assertEquals(4, new LongestIncreasingSubsequence().lengthOfLISDP(new int[]{10, 2, 5, 3, 7, 101, 18}));

        assertEquals(3, new LongestIncreasingSubsequence().lengthOfLISPatienceSort(new int[]{3, 10, 2, 1, 20}));
        assertEquals(4, new LongestIncreasingSubsequence().lengthOfLISPatienceSort(new int[]{10, 2, 5, 3, 7, 101, 18}));

        assertEquals(3, new LongestIncreasingSubsequence().lengthOfLISNew(new int[]{3, 10, 2, 1, 20}));
        assertEquals(4, new LongestIncreasingSubsequence().lengthOfLISNew(new int[]{10, 2, 5, 3, 7, 101, 18}));
    }

}