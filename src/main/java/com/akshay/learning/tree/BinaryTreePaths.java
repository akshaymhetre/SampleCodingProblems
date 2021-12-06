package com.akshay.learning.tree;

import java.util.ArrayList;
import java.util.List;

/*
* Given the root of a binary tree, return all root-to-leaf paths in any order.

A leaf is a node with no children.



Example 1:


Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]
* */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        final List<String> res = new ArrayList<>();
        _binaryTreePaths(root, res, "");
        return res;
    }

    private void _binaryTreePaths(TreeNode root, List<String> res, String path) {
        if(root == null) return;
        if(root.left == null && root.right == null){
            res.add(path + root.val);
        }
        if(root.left != null) _binaryTreePaths(root.left, res, path + root.val + "->");
        if(root.right != null) _binaryTreePaths(root.right, res, path + root.val + "->");
    }

}
