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
        // base case: if the stack is empty or
        // the key is greater than all elements in the stack
        if (stack.isEmpty() || top.compareTo(stack.peek()) > 0)
        {
            stack.push(top);
            return;
        }

        /* We reach here when the key is smaller than the top element */

        // remove the top element
        T popElement = stack.pop();

        // recur for the remaining elements in the stack
        insertTopInSortedStack(stack, top);

        // insert the popped element back into the stack
        stack.push(popElement);
    }
}
