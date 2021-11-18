package com.akshay.learning.misc;

/*
* Given a 2D screen, location of a pixel in the screen and a color,
* replace color of the given pixel and all adjacent same colored pixels with the given color.
* Input: image = [[1,1,1],
*                 [1,1,0],
*                 [1,0,1]
*                 ], sr = 1, sc = 1, newColor = 2
* Output: [[2,2,2],
*          [2,2,0],
*          [2,0,1]]
*
* Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel),
* all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel
* */
public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor){
        int srcColor = image[sr][sc];
        if(srcColor != newColor){
            dfs(image, sr, sc, srcColor, newColor);
        }
        return null;
    }

    private void dfs(int[][] image, int r, int c, int srcColor, int newColor) {
        if(image[r][c] == srcColor){
            image[r][c] = newColor;
            if(r+1 < image.length) dfs(image, r+1, c, image[r+1][c], newColor);
            if(c+1 < image[0].length) dfs(image, r, c+1, image[r][c+1], newColor);
            if(r-1 >= 0) dfs(image, r-1, c, image[r-1][c], newColor);
            if(c-1 >= 0) dfs(image, r, c-1, image[r][c-1], newColor);
        }
    }
}
