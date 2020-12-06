package com.company;

public class LeetCode_74 {
/**
 * Copyright (C), 2019-2019, citi Group
 * Filename: LeetCode_74
 * Author: wyf
 * Date: 20190922 17:31
 * Description: 搜索二维矩阵
 * History:
 *
 */
public boolean searchMatrix(int[][] matrix, int target) {
    if(matrix.length == 0) return false;
    if(matrix[0].length == 0) return false;
    int low = 0, high = matrix.length - 1;
    int row_mid = 0;
    int col_mid = 0;
    while(low <= high){
        row_mid = (low + high) / 2;
        if(matrix[row_mid][0] > target) high = row_mid - 1;
        else if(matrix[row_mid][0] <= target){
            if(matrix[row_mid][0] == target) return true;
            else if(row_mid < matrix.length - 1){
                if(matrix[row_mid+1][0] > target) break;
                else low = row_mid + 1;
            }
            else break;
        }
    }
    low = 0;
    high = matrix[0].length - 1;
    while(low <= high){
        col_mid = (low + high) / 2;
        if(matrix[row_mid][col_mid] == target) return true;
        else if(matrix[row_mid][col_mid] > target) high = col_mid - 1;
        else low = col_mid + 1;
    }
    return false;
}
}
