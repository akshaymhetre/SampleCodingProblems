package com.akshay.learning.linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReorderListTest {
    @Test
    public void shouldWork(){
        assertArrayEquals(new int[]{1,4,2,3}, new ReorderList().reorderList(ListNode.buildList(new int[]{1,2,3,4})));
    }
}