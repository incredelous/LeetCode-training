package com.company;

public class LeetCode_59 {
/**
 * Copyright (C), 2019-2019, citi Group
 * Filename: LeetCode_59
 * Author: wyf
 * Date: 20190904 22:46
 * Description: 螺旋矩阵II
 * History:
 *
 */
public int[][] generateMatrix(int n) {
    int[][] ret = new int[n][n];
    int r1 = 0, r2 = n - 1;
    int c1 = 0, c2 = n - 1;
    int num = 1;
    int i = 0;
    while(r1 < r2 && c1 < c2){
        for(i = c1; i <= c2; i++) ret[r1][i] = num++;
        for(i = r1+1; i <= r2; i++) ret[i][c2] = num++;
        for(i = c2-1; i >= c1; i--) ret[r2][i] = num++;
        for(i = r2-1; i > r1; i--) ret[i][c1] = num++;
        r1++; r2--;
        c1++; c2--;
    }
    return ret;
}
}
