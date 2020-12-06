package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeetCode_54 {
/**
 * Copyright (C), 2019-2019, citi Group
 * Filename: LeetCode_54
 * Author: wyf
 * Date: 20190829 23:00
 * Description: 螺旋矩阵
 * History:
 *
 */
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0){ return new ArrayList<Integer>(); }
        int m = matrix.length, n = matrix[0].length;
        Integer[] ret = new Integer[m * n];
        int counter = 0;
        int i = 0;
        while(i < m*n){
            for(int j = counter; j < n - counter; j++) {
                ret[i++] = matrix[counter][j];
            }
            if(i >= m*n){break;}
            for(int j = counter+1; j < m - counter; j++) {
                ret[i++] = matrix[j][n - counter - 1];
            }
            if(i >= m*n){break;}
            for(int j = n - counter - 2; j >= counter; j--) {
                ret[i++] = matrix[m -
                        - 1][j];
            }
            if(i >= m*n){break;}
            for(int j = m - counter - 2; j > counter; j--) {
                ret[i++] = matrix[j][counter];
            }
            counter++;
        }
        return Arrays.asList(ret);
    }

}
