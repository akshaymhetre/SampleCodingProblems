package com.akshay.learning.misc.heap;

import com.sun.tools.javac.util.List;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SkylineProblemTest {
    @Test
    public void shouldWork(){
        assertEquals(List.of(List.of(1)), new SkylineProblem().getSkyline(new int[][]{
                {2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}}));
    }
}