package com.akshay.learning.sorting.quickSortType.QuickSelect;

import org.junit.Test;

import static org.junit.Assert.*;

public class KthLargestTest {
    @Test
    public void shouldWork(){
        assertEquals(5, new KthLargest().findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }
}