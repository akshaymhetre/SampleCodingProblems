package com.akshay.learning.tree;

import java.util.ArrayList;
import java.util.List;

/*
* Given the root of a binary tree, imagine yourself standing on the right side of it,
* return the values of the nodes you can see ordered from top to bottom.*/
public class RightSideTree {
    List<Integer> nodes = new ArrayList<>();
    int maxRightHeightSoFar = -1;
    public List<Integer> rightSideView(TreeNode root) {
        _rightSideView(root, 0);
        return nodes;
    }

    // return height
    void _rightSideView(TreeNode root, int height){
        if(root == null) {
            return;
        }
        if(height > maxRightHeightSoFar){
            maxRightHeightSoFar = height;
            nodes.add(root.val);
        }
        _rightSideView(root.right, height+1);
        _rightSideView(root.left, height+1);
    }
}