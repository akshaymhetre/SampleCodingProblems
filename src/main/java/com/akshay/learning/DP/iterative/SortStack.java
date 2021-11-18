package com.akshay.learning.DP.iterative;

import java.util.Stack;

public class SortStack {
    public <T extends Comparable<T>> Stack<T> sort(Stack<T> stack){
        Stack<T> stackOther = new Stack<>();
        while(!stack.isEmpty()){
            T pop = stack.pop();
            while(!stackOther.isEmpty() && pop.compareTo(stackOther.peek()) < 0){
                T pop1 = stackOther.pop();
                stack.push(pop1);
            }
            stackOther.push(pop);
        }
        return stackOther;
    }
}
