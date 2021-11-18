package com.akshay.learning.tree;

import java.util.*;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode buildFromLevelOrder(int[] arr){
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = null;
        for (int j : arr) {
            TreeNode treeNode = null;
            if(j != -1) treeNode = new TreeNode(j);
            if (root == null) root = treeNode;
            else if (queue.peek() != null && queue.peek().left == null) {
                queue.peek().left = treeNode;
            } else if (queue.peek() != null) {
                queue.peek().right = treeNode;
                queue.remove();
            }
            if(treeNode != null) {
                queue.add(treeNode);
            }
        }
        return root;
    }

    public static List<Integer> getLevelOrder(TreeNode root){
        List<Integer> levelOrder = new ArrayList<>();
        if(root == null) return levelOrder;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode treeNode = queue.poll();
            if(treeNode != null) {
                levelOrder.add(treeNode.val);
                queue.add(treeNode.left);
                queue.add(treeNode.right);
            }
        }
        return levelOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return val == treeNode.val;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }
}
