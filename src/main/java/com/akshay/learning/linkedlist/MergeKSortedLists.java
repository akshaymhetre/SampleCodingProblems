package com.akshay.learning.linkedlist;

import java.util.*;

/*
https://leetcode.com/problems/merge-k-sorted-lists/

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.



Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, Comparator.comparing(obj -> obj.val));

        /*
        * for (ListNode headNode :
                lists) {
            minHeap.add(headNode);
        }
        * Short line code below instead */
        // all all head nodes in heap
        minHeap.addAll(Arrays.asList(lists));

        // This is to avoid checking head is null or not
        ListNode resDummyHead = new ListNode(0);
        ListNode currNode = resDummyHead;

        // Keep queue to track pointers for all nodes
        Queue<ListNode> queue = new LinkedList<>();
        queue.add(minHeap.poll());
        while (!queue.isEmpty()) {
            ListNode nextNode = queue.poll();
            currNode.next = nextNode;
            currNode = nextNode;
            if(currNode.next != null)
                minHeap.add(currNode.next);
        }
        return resDummyHead.next;
    }
}
