package com.akshay.learning.misc.StringAlgo;

import org.junit.Test;

import static org.junit.Assert.*;

public class KMPMatcherTest {
    @Test
    public void shouldWork(){
        assertTrue(new KMPMatcher().KMP("abcxabcdabcdabcy".toCharArray(), "abcdabcy".toCharArray()));
    }

}