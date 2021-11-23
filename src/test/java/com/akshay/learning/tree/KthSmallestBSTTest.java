package com.akshay.learning.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class KthSmallestBSTTest {
    @Test
    public void shouldWork(){
        assertEquals(1, new KthSmallestBST().kthSmallest(TreeNode.buildFromLevelOrder(new int[]{3,1,4,-1,2}), 1));
    }
}