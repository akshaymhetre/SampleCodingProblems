package com.akshay.learning.DP.recursive;

import java.util.Stack;

public class SortStack {
    public <T extends Comparable<T>> void sort(Stack<T> stack){
        if(!stack.isEmpty()){
            T top = stack.pop();
            sort(stack);
            insertTopInSortedStack(stack, top);
        }
    }

    private <T extends Comparable<T>> void insertTopInSortedStack(Stack<T> stack, T top) {
        if(!stack.isEmpty()){
            if(top.compareTo(stack.peek()) < 0){
                T popElement = stack.pop();
                insertTopInSortedStack(stack, popElement);
            }
        }
        stack.push(top);
    }
}
