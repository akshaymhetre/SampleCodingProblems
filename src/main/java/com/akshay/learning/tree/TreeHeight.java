package com.akshay.learning.tree;

public class TreeHeight {
    public int getHeight(TreeNode treeNode){
        if(treeNode == null) return -1;
        final int leftHeight = getHeight(treeNode.left);
        final int rightHeight = getHeight(treeNode.right);
        return 1+Math.max(leftHeight, rightHeight);
    }
}
