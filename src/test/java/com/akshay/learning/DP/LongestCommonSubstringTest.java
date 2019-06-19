package com.akshay.learning.DP;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LongestCommonSubstringTest {

    @Test
    public void lengthOfLCSRecursion() {
        final LongestCommonSubstring longestCommonSubstring = new LongestCommonSubstring("abcdxyz", "xyzabcd");
        Assert.assertEquals(4, longestCommonSubstring.lengthOfLCSRecursion());
    }

    @Test
    public void lengthOfLCSDP() {
        final LongestCommonSubstring longestCommonSubstring = new LongestCommonSubstring("abcdxyz", "xyzabcd");
        Assert.assertEquals(4, longestCommonSubstring.lengthOfLCSDP());
    }
}