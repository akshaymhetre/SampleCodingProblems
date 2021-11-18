package com.akshay.learning.DP.iterative;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoinChangeSolutionTest {
    @Test
    public void shouldWork(){
        CoinChangeTotalWays coinChangeSolution = new CoinChangeTotalWays();
        assertEquals(5, coinChangeSolution.solution(new int[]{1, 2, 3}, 5));
        assertEquals(10, coinChangeSolution.solution(new int[]{1, 2, 3}, 8));
    }
}