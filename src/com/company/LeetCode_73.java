package com.company;

public class LeetCode_73 {
/**
 * Copyright (C), 2019-2019, citi Group
 * Filename: LeetCode_73
 * Author: wyf
 * Date: 20190921 23:36
 * Description: 矩阵置零
 * History:
 *
 */
public void setZeroes(int[][] matrix) {
    boolean row = false;
    boolean col = false;
    for(int i = 0; i < matrix.length; i++) {
        if(matrix[i][0] == 0){
            col = true;
            break;
        }
    }

    for(int i = 0; i < matrix[0].length; i++) {
        if(matrix[0][i] == 0){
            row = true;
            break;
        }
    }

    for(int i = 1; i < matrix.length; i++) {
        for(int j = 1; j < matrix[0].length; j++) {
            if(matrix[i][j] == 0){
                matrix[i][0] = 0;
                matrix[0][j] = 0;
            }
        }
    }
    for(int i = 1; i < matrix.length; i++) {
        if(matrix[i][0] == 0){
            for(int j = 1; j < matrix[0].length; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    for(int i = 1; i < matrix[0].length; i++) {
        if(matrix[0][i] == 0){
            for(int j = 1; j < matrix.length; j++) {
                matrix[j][i] = 0;
            }
        }
    }
    if(row){
        for(int i = 0; i < matrix[0].length; i++) {
            matrix[0][i] = 0;
        }
    }
    if(col){
        for(int i = 0; i < matrix.length; i++) {
            matrix[i][0] = 0;
        }
    }
}
}
