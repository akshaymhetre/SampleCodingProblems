package com.akshay.learning.linkedlist;

import java.util.List;
/*
  https://leetcode.com/problems/reorder-list/
* 1->2->3->4->5 = 1->5->2->4->3
// 1->2->3->4 => 1->2->4->3 => 1->4->2->3
Logic:
    - Go to middle
                          s        m       s        m                  s     m       s     m
    - reverse second half 1->2->3->4->5 => 1->2->3->5->4, in case even 1->2->3->4 => 1->2->4->3
    - start rearranging two list start with s & m
* */
public class ReorderList {
    //ListNode headTemp;
    public int[] reorderList(ListNode head) {
        // as per problem statment list will always have one value
        if(head.next == null) return null;
        final ListNode middle1 = getMiddle(head);
        ListNode middle = reverse(middle1);
        ListNode start = head;
        ListNode middleNext;
        while (middle.next != null) {
            middleNext = middle.next;
            middle.next = start.next;
            start.next = middle;
            start = start.next.next;
            middle = middleNext;
        }
        return ListNode.getList(head);
    }

    //1->2->3->4->5
    private ListNode getMiddle(ListNode head) {
        ListNode fast = head, slow =head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, next = null;
        while (head != null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

}
