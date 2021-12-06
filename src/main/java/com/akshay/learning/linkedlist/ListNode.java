package com.akshay.learning.linkedlist;

import java.util.ArrayList;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode buildList(int[] nums){
        ListNode head = null;
        ListNode temp = null;
        for (int i = 0; i < nums.length; i++) {
            if(head == null)
                head = temp = new ListNode(nums[i]);
            else {
                temp.next = new ListNode(nums[i]);
                temp = temp.next;
            }
        }
        return head;
    }

    public static int[] getList(ListNode head){
        final ArrayList<Integer> elements = new ArrayList<>();
        while (head != null){
            elements.add(head.val);
            head = head.next;
        }
        return elements.stream().mapToInt(i -> i).toArray();
    }
}
