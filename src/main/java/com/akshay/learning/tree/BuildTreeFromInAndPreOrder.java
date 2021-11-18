package com.akshay.learning.tree;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

// Assume all are unique

* Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree
* and inorder is the inorder traversal of the same tree, construct and return the binary tree.
*
* Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
  Output: [3,9,20,null,null,15,7]
* */
public class BuildTreeFromInAndPreOrder {
    int preOrderIndex = 0;
    Map<Integer, Integer> inorderIndex = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        }
        return _buildTree(preorder, 0, inorder.length-1);
    }

    private TreeNode _buildTree(int[] preorder, int left, int right) {
        if(left > right) {
            return null;
        }
        int data = preorder[preOrderIndex++];
        TreeNode root = new TreeNode(data);
        root.left = _buildTree(preorder, left, inorderIndex.get(data)-1);
        root.right = _buildTree(preorder, inorderIndex.get(data)+1, right);
        return root;
    }
}

