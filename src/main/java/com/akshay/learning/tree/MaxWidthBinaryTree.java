package com.akshay.learning.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthBinaryTree {
    public int getWidth(TreeNode root){
        if(root == null) return -1;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        int maxWidth = 0;
        while (!queue.isEmpty()){
            int levelNodes = queue.size();
            int leftIndex = 0, rightIndex = 0;
            int levelFirstIndex = queue.peek().index;    //to make the id starting from zero
            for (int i = 0; i < levelNodes; i++) {
                final Pair pair = queue.poll();
                final int currentIndex = pair.index-levelFirstIndex;
                if (i == 0) leftIndex = currentIndex;
                if(i == levelNodes-1) rightIndex = currentIndex;
                if (root.left != null) {
                    queue.offer(new Pair(root.left, 2*currentIndex+1));
                }
                if (root.right != null) {
                    queue.offer(new Pair(root.right, 2*currentIndex+2));
                }
            }
            maxWidth = Math.max(maxWidth, rightIndex-leftIndex+1);
        }
        return maxWidth;
    }

    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        while(!q.isEmpty()){
            int size = q.size();
            int mmin = q.peek().index;    //to make the id starting from zero
            int first = 0,last = 0;
            for(int i=0; i<size; i++){
                int cur_id = q.peek().index-mmin;
                TreeNode node = q.peek().treeNode;
                q.poll();
                if(i==0) first = cur_id;
                if(i==size-1) last = cur_id;
                if(node.left != null)
                    q.offer(new Pair(node.left, cur_id*2+1));
                if(node.right != null)
                    q.offer(new Pair(node.right, cur_id*2+2));
            }
            ans = Math.max(ans, last-first+1);
        }
        return ans;
    }


    class Pair {
        TreeNode treeNode;
        int index;

        public Pair(TreeNode treeNode, int index) {
            this.treeNode = treeNode;
            this.index = index;
        }
    }
}
