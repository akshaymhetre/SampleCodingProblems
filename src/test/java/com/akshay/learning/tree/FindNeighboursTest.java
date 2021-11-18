package com.akshay.learning.tree;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class FindNeighboursTest {
    @Test
    public void shouldWork(){
        TreeNode node = TreeNode.buildFromLevelOrder(new int[]{3,5,1,6,2,0,8,-1,-1,7,4});
        assertEquals(Arrays.asList(3,5,1,6,2,0,8,7,4), TreeNode.getLevelOrder(node));
        //assertEquals(Arrays.asList(5,1), new FindNeighbours().distanceK(node, new TreeNode(3), 1));
        assertEquals(Arrays.asList(2,3,6), new FindNeighbours().distanceK(node, new TreeNode(5), 1));
    }
}