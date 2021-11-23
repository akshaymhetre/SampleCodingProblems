package com.akshay.learning.DP.iterative;

import com.akshay.learning.DP.recursive.LongestPathMatrix;
import org.junit.Test;

import static org.junit.Assert.*;

public class LongestPathMatrixTest {
    @Test
    public void shouldWork(){
        // The longest increasing path is [1, 2, 6, 9].
        assertEquals(4, new LongestPathMatrix().longestIncreasingPath(new int[][]{{9,9,4},{6,6,8},{2,1,1}}));
        assertEquals(2, new LongestPathMatrix().longestIncreasingPath(new int[][]{{1,2}}));
    }
}