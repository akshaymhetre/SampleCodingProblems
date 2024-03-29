package com.akshay.learning.linkedlist;

/*
https://leetcode.com/problems/merge-two-sorted-lists/
* Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
* */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
