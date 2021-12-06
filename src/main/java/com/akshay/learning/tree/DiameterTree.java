package com.akshay.learning.tree;

public class DiameterTree {
    int max;
    public int diameter(TreeNode treeNode) {
        return _diameter(treeNode, 0);
    }

    private int _diameter(TreeNode treeNode, int ht) {
        if(treeNode == null) return ht;
        final int leftHt = _diameter(treeNode.left, ht + 1);
        final int rightHt = _diameter(treeNode.right, ht + 1);
        final int diameter = 1 + leftHt + rightHt;
        max = Math.max(max, diameter);
        return Math.max(leftHt, rightHt);
    }


    // By Take u fiorward
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        height(root, diameter);
        return diameter[0];
    }

    private int height(TreeNode node, int[] diameter) {
        if (node == null) {
            return 0;
        }
        int lh = height(node.left, diameter);
        int rh = height(node.right, diameter);
        diameter[0] = Math.max(diameter[0], lh + rh);
        return 1 + Math.max(lh, rh);
    }
}
