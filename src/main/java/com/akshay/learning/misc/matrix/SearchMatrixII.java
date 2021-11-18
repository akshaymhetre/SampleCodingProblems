package com.akshay.learning.misc.matrix;

/*
* Write an efficient algorithm that searches for a target value in an m x n integer matrix. The matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
*
* Input: matrix = [[1,4,7,11,15],
*                  [2,5,8,12,19],
*                  [3,6,9,16,22],
*                  [10,13,14,17,24],
*                  [18,21,23,26,30]], target = 5
Output: true
*
* Hint: Start from top-right corner(because left of it is decreasing and down from that increasing)
*
* */
public class SearchMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int midRow = 0;
        int midCol = matrix[0].length-1;

        while (midRow < matrix.length && midCol >= 0){
            int ele = matrix[midRow][midCol];
            if(ele == target){
                return true;
            } else if(target < ele){
                midCol--;
            } else {
                midRow++;
            }
        }
        return false;
    }
}
