package com.akshay.learning.misc;

// asked in oracle
public class PrintPyramid {
    /* for row 4 ->
      1
    1 2 1
  1 2 3 2 1
1 2 3 4 3 2 1
* */
    public static void printPyramid(int numOfRows) {
        if (numOfRows < 1) return;
        for (int i = 0; i < numOfRows; i++) {
            // left side spaces
            // 0, 1, 2 < 3
            for (int spaceIndex = 0; spaceIndex < numOfRows - 1 - i; spaceIndex++) {
                System.out.print("  ");
            }
            int k = 1;
            // incrementing part
            while (k <= i + 1) {
                System.out.print(k + " ");
                k++;
            }
            k--;
            // decrementing part
            while (k > 1) {
                k--;
                System.out.print(k + " ");
            }
            System.out.println();
        }

    }
}
