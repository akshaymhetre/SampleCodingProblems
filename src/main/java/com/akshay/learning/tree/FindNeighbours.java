package com.akshay.learning.tree;

import java.util.*;
import java.util.stream.Collectors;

/*
Given a node in this BST and a distance (K), you need to find out /  print all neighbours of the given node at a distance ok K
https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/

Logic:
1. Maintain Link to parent using hashmap
2. DO BFS but this time add target node and try to go till distance K from that node like a graph.

Explanation: https://www.youtube.com/watch?v=i9ORlEy6EsI
 */
public class FindNeighbours {
    Map<TreeNode, TreeNode> childToParentMapping = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(target == null) return Collections.emptyList();
        collectParentMapping(root, null);
        // BFS
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        int dist = 0;
        queue.add(target);
        while (!queue.isEmpty() && dist != k){
            List<TreeNode> nodes = new ArrayList<>();
            while (!queue.isEmpty()){
                TreeNode poll = queue.poll();
                visited.add(poll);
                nodes.add(poll);
            }
            for (TreeNode node: nodes) {
                if(node.left != null && !visited.contains(node)) queue.add(node.left);
                if(node.right != null && !visited.contains(node)) queue.add(node.right);
                // add parent as well
                final TreeNode parentNode = childToParentMapping.get(node);
                if(parentNode != null && !visited.contains(parentNode)) queue.add(parentNode);
            }
            dist++;
        }
        return queue.stream().map(treeNode -> treeNode.val).collect(Collectors.toList());
    }

    private void collectParentMapping(TreeNode root, TreeNode parent) {
        if(root == null) return;
        childToParentMapping.put(root, parent);
        collectParentMapping(root.left, root);
        collectParentMapping(root.right, root);
    }

//    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
//        findNeighbours(root, target.val, k, false);
//        return neighbours;
//
//    }
//    // keep two values : [found= 0 or 1, k return from child (-1 if not found yet)]
//    int[] findNeighbours(TreeNode root, int num, int k, boolean isFound){
//        boolean foundNode = isFound;
//        if(root == null){
//            return new int[]{foundNode ? 1: 0 , -1};
//        }
//        if(root.val == num){
//            System.out.println("found num: "+num);
//            foundNode = true;
//        }
//        if(foundNode && k == 0){
//            System.out.println("found neighbour: "+root.val);
//            neighbours.add(root.val);
//            return new int[]{1 , -1};
//        }
//        int resK = -1;
//        if(!foundNode){
////            if(num < root.val){
////                resK = findNeighbours(root.left, num, k);
////            } else {
////                resK = findNeighbours(root.right, num, k);
////            }
//            resK = Math.max(findNeighbours(root.left, num, k, false)[1],
//                    findNeighbours(root.right, num, k, false)[1]);
//        } else {
//            resK = Math.max(findNeighbours(root.left, num, k-1, true)[1],
//                    findNeighbours(root.right, num, k-1, true)[1]);
//        }
//        System.out.println("ret val ["+ resK+"] received for parent: "+root.val);
//        if(resK == 0){
//            neighbours.add(root.val);
//        }
//        if(root.val == num){
//            System.out.println();
//        }
//        int i = (resK > 0) ? resK - 1 : ((root.val == num) ? k - 1 : resK);
//        System.out.println("sending val ["+ i+"] from child : "+root.val);
//        return new int[]{foundNode ? 1: 0 , -1};
//    }
}
