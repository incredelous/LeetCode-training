package com.company;

public class LeetCode_85 {
/**
 * Copyright (C), 2019-2019, citi Group
 * Filename: LeetCode_85
 * Author: wyf
 * Date: 20191027 15:21
 * Description: 最大矩形
 * History:
 *
 */
public int maximalRectangle(char[][] matrix) {
    int maxArea = 0;
    if(matrix.length == 0 || matrix[0].length == 0) return 0;
    int[][] maxWidth = new int[matrix.length][matrix[0].length];
    for(int i = 0; i < matrix.length; i++) {
        for(int j = 0; j < matrix[0].length; j++) {
            if(matrix[i][j] == '0'){
                maxWidth[i][j] = 0;
                continue;
            }
            maxWidth[i][j] = j == 0 ? 1 : maxWidth[i][j-1] + 1;
            int minWidth = Integer.MAX_VALUE;
            for(int k = i; k >=  0; k--) {
                minWidth = Math.min(maxWidth[k][j], minWidth);
                maxArea = Math.max(maxArea, minWidth * (i-k+1));
            }
        }
    }
    return maxArea;
}
}
