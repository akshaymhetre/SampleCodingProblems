package com.akshay.learning.linkedlist;

public class RotateByK {
    public <T> Node<T> rotate(Node<T> head, int K){
        int len = lengthOfList(head);
        if(len == 0) return head;
        K = K%len;
        if (K == 0) return head;

        attachTailToHead(head);
        Node<T> prev = head;
        while (K > 1){
            prev = prev.getNext();
        }
        head = prev.getNext();
        prev.setNext(null);
        return head;
    }

    private <T> void attachTailToHead(Node<T> head) {
        Node<T> last = head;
        while (last.getNext() != null){
            last = last.getNext();
        }
        last.setNext(head);
    }

    private <T> int lengthOfList(Node<T> head) {
        if(head == null) return 0;
        return 1+lengthOfList(head.getNext());
    }
}
