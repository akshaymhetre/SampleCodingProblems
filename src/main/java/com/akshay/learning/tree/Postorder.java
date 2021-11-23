package com.akshay.learning.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Postorder {
    List<String> scrapper = new ArrayList<>();
    public void postorder(TreeNode root){
        if(root != null){
            postorder(root.left);
            postorder(root.right);
            scrapper.add(String.valueOf(root.val));
        }
    }

    public void inorder(TreeNode root){
        if(root != null){
            inorder(root.left);
            scrapper.add(String.valueOf(root.val));
            inorder(root.right);
        }
    }

    public void postorderIterativeTwoStack(TreeNode root){
        Deque<TreeNode> stack1 = new ArrayDeque<>();
        Deque<TreeNode> stack2 = new ArrayDeque<>();
        stack1.push(root);
        while (!stack1.isEmpty()){
            TreeNode popNode = stack1.pop();
            stack2.push(popNode);
            if(popNode.left != null){
                stack1.push(popNode.left);
            }
            if(popNode.right != null){
                stack1.push(popNode.right);
            }
        }
        // Add stack 2 data which is postorder
        while(!stack2.isEmpty()){
            scrapper.add(String.valueOf(stack2.pop().val));
        }
    }

    public void preorderIterative(TreeNode root){
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode popNode = stack.pop();
            scrapper.add(String.valueOf(stack.pop().val));
            if(popNode.right != null){
                stack.push(popNode.right);
            }
            if(popNode.left != null){
                stack.push(popNode.left);
            }
        }
    }

    public void inorderIterative(TreeNode root){
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()){
            TreeNode top = stack.peek();
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.peek();
            scrapper.add(String.valueOf(curr.val));
            stack.pop();
            curr = curr.right;
        }
    }


}
