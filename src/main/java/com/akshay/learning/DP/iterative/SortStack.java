package com.akshay.learning.DP.iterative;

import java.util.Stack;

public class SortStack {
    public <T extends Comparable<T>> Stack<T> sort(Stack<T> stack){
        Stack<T> stackOther = new Stack<>();
        while(!stack.isEmpty()){
            T pop = stack.pop();
            // pop < stackOther.top()
            // move elements from stackOther to stack till our given pop elment is lesser
            // that is stackOther will always be in sorted state
            while(!stackOther.isEmpty() && pop.compareTo(stackOther.peek()) < 0){
                T pop1 = stackOther.pop();
                stack.push(pop1);
            }
            stackOther.push(pop);
        }
        return stackOther;
    }
}
