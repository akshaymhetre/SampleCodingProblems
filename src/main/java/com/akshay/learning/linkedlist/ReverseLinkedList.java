package com.akshay.learning.linkedlist;

public class ReverseLinkedList {
    public <T> Node<T> reverseRecursion(Node<T> head){
        if(head == null)
            return null;
        if(head.getNext() == null)
            return head;
        Node<T> reverse = reverseRecursion(head.getNext());
        reverse.setNext(head);
        return reverse;
    }

    public <T> Node<T> reverseIterative(Node<T> head){
        if(head == null)
            return null;
        Node<T> current = head, prev = null, next = null;
        while(current !=null){
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        return prev;
    }
}
