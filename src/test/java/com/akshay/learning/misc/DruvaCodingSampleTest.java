package com.akshay.learning.misc;

import org.junit.Test;

import static org.junit.Assert.*;

public class DruvaCodingSampleTest {
    @Test
    public void shouldWork(){
        assertEquals(3, new DruvaCodingSample().minLength("abc"));
        assertEquals(4, new DruvaCodingSample().minLength("aabbcc"));
        assertEquals(3, new DruvaCodingSample().minLength("aabbccabc"));
    }
}