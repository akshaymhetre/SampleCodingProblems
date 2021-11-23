package com.akshay.learning.misc;

import com.akshay.learning.linkedlist.Node;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
* Delete node at given index
* */
public class DruvaCodingSample {

    public Node<Integer> deleteNodeAtIndexNew(Node<Integer> head, int index){

        if(index < 0) return head;
        // head is getting deleted
        if(index == 0){
            return (head != null) ? head.getNext() : null;
        }
        // placing pointer to given index
        Node<Integer> prev = head;
        while(index > 1 && prev != null){
            prev = prev.getNext();
            index--;
        }
        if(prev == null || prev.getNext() == null){
            return head;
        }
        Node<Integer> next = prev.getNext().getNext();
        prev.getNext().setNext(null);
        prev.setNext(next);
        return head;
    }

    public Node<Integer> deleteNodeAtIndex(Node<Integer> head, int index){
        Node<Integer> prev = null, curr = head;
        if(index < 0) return head;
        // head is getting deleted
        if(index == 0){
            return (head != null) ? head.getNext() : null;
        }
        // placing pointer to given index
        while(index > 0 && curr != null){
            prev = curr;
            curr = curr.getNext();
            index--;
        }
        if(curr == null){
            return head;
        }
        if(prev != null) {
            prev.setNext(curr.getNext());
            curr.setNext(null);
        }
        return head;
    }

    // string with small letters, find min substring length that contains all the characters of the input string at least once
    // inp = abc, op = abc
    //  l  r
    // aabbcc -> abbc
    public int minLength(String str){
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : str.toCharArray()) {
            uniqueChars.add(c);
        }
        int totalUniqueChars = uniqueChars.size();
        int[] formedCharFreq = new int[26];
        int formedCharUniqueCnt = 0;
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        while(right < str.length()){
            int currFreq = formedCharFreq[str.charAt(right) - 'a'];
            if(currFreq == 0){
                formedCharUniqueCnt++;
            }
            formedCharFreq[str.charAt(right) - 'a'] = currFreq+1;
            while(formedCharUniqueCnt == totalUniqueChars){
                minLen = Math.min(minLen, right-left+1);
                formedCharFreq[str.charAt(left) - 'a']--;
                if(formedCharFreq[str.charAt(left) - 'a'] == 0){
                    formedCharUniqueCnt--;
                }
                left++;
            }
            right++;
        }

        return (minLen == Integer.MAX_VALUE) ? -1 : minLen;
    }
}
