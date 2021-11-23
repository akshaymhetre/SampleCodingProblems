package com.akshay.learning.misc.PrefixSuffixType;

import java.util.Stack;

/*
* https://leetcode.com/problems/largest-rectangle-in-histogram/
* Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
* return the area of the largest rectangle in the histogram.

Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
*
* Logic: PART-1 https://www.youtube.com/watch?v=X0X6G-eWgQ8
* PART-2: https://www.youtube.com/watch?v=jC_cWLy7jSI
 * */
public class LargestRectangleHistogram {
    /*
    * Logic:
    * Thought process:
    * - Keep stack with increasing height
    * - found boundries for nearest small element on left and right side for current index, this way you get width
    * - for each element X in arr, compare top of stack T
    *   - if found greater then push
    *   - but if found smaller or equal, then for top T, right side index is X, and left side index is element on stack before T
    *       - find width = rightIndex-leftIndex+1
    * - handle corner cases if first element or last element is getting added or stack gets emmpy before processing all elements
    *
    * 2,1,5,6,2,3
    *
    *
    * */
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxA = 0;
        for(int cut = 0;cut<=n;cut++) {
            // found lesser element than stack top or last element
            while(!st.isEmpty() && (cut==n || heights[cut] <= heights[st.peek()] )) {
                int height = heights[st.pop()];
                int width;
                if(st.isEmpty()) width = cut;
                else width = cut - st.peek() - 1;

                // cout << cut << " " << width << " " << height << endl;
                maxA = Math.max(maxA, width * height);
            }
            st.push(cut);
        }
        return maxA;
//        Stack<Integer> stack = new Stack<>();
//        int maxArea = 0;
//        for (int i = 0; i < heights.length; i++) {
//            int currHeight = heights[i];
//            int currIndex = i;
//            if(stack.isEmpty() || heights[stack.peek()] < currHeight)
//                stack.push(i);
//            else {
//                System.out.println("Stack + "+ stack.toString());
//                while (!stack.isEmpty() && heights[stack.peek()] >= currHeight) {
//                    int popIndex = stack.pop();
//                    int popHeight = heights[popIndex];
//                    int popWidth = (stack.isEmpty()) ? 1: currIndex-stack.peek()-1;
//                    System.out.println("element: "+heights[popIndex]+ ", popWidth: "+ popWidth+", currIndex: "+currIndex);
//                    if(!stack.isEmpty()) System.out.println("peek: "+ stack.peek());
//                    maxArea = Math.max(maxArea, popHeight*popWidth);
//                }
//                stack.push(i);
//            }
//        }
//        // for last element
//        System.out.println("Stack + "+ stack.toString());
//        int right = heights.length;
//        while(!stack.isEmpty()){
//            int popIndex = stack.pop();
//            int popHeight = heights[popIndex];
//            System.out.println("element: "+heights[popIndex]);
//            int popWidth = (stack.isEmpty()) ? right: right-stack.peek()-1;
//            maxArea = Math.max(maxArea, popHeight*popWidth);
//            right = popIndex;
//        }
//        return maxArea;
    }
}
