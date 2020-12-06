package com.company;

public class LeetCode_48 {
    /**
     * Copyright (C), 2019-2019, citi Group
     * Filename: LeetCode_48
     * Author: wyf
     * Date: 20190819 21:46
     * Description: 旋转图像
     * History:
     * v1 题解 https://leetcode-cn.com/problems/rotate-image/solution/xuan-zhuan-tu-xiang-by-leetcode/ 解法2
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n / 2 + n % 2; i++) {
            for(int j = 0; j < n / 2; j++) {
                int[] tmp = new int[4];
                int row = i, col = j;
                for(int k = 0; k < 4; k++) {
                    tmp[k] = matrix[row][col];
                    int x = row;
                    row = col;
                    col = n - 1 - x;
                }
                for(int k = 0; k < 4; k++) {
                    matrix[row][col] = tmp[(k + 3) % 4];
                    int x = row;
                    row = col;
                    col = n - 1 - x;
                }
            }
        }
    }
}
