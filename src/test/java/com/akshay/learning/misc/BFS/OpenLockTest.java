package com.akshay.learning.misc.BFS;

import org.junit.Test;

import static org.junit.Assert.*;

public class OpenLockTest {
    @Test
    public void shouldWork(){
        assertEquals(6, new OpenLock().openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
    }
}