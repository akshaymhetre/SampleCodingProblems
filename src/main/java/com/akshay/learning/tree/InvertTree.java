package com.akshay.learning.tree;

import java.util.LinkedList;
import java.util.Queue;

/*
* Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]
* */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        root.left = invertTree(root.right);
        root.right = invertTree(root.left);
        return root;
    }

    public TreeNode invertTreeIterative(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }

}
