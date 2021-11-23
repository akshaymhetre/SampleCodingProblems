package com.akshay.learning.tree;

/*
* 1 <= k <= n <= 104
* */
public class KthSmallestBST {
    int inorderElementCount = 0;
    boolean hasFound = false;
    int res = -1;
    public int kthSmallest(TreeNode root, int k) {
        kthSmallestRec(root, k);
        return res;
    }

    // reach to extreme left
    // while returning
    private void kthSmallestRec(TreeNode root, int k) {
        if(root != null && !hasFound) {
            kthSmallestRec(root.left, k);
            if(!hasFound) {
                inorderElementCount++;
                if (inorderElementCount == k) {
                    hasFound = true;
                    res = root.val;
                }
                if(!hasFound) kthSmallestRec(root.right, k);
            }
        }
    }
}
