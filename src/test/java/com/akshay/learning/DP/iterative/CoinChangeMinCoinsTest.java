package com.akshay.learning.DP.iterative;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoinChangeMinCoinsTest {
    @Test
    public void shouldWork(){
        CoinChangeMinCoins coinChangeMinCoins = new CoinChangeMinCoins();
        assertEquals(2, coinChangeMinCoins.solution(new int[]{1, 5, 6, 8}, 11));
    }
}