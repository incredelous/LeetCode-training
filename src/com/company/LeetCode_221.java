package com.company;

public class LeetCode_221 {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null) return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        int maxSide = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == '1'){
                    if(i == 0 || j == 0) dp[i][j] = 1;
                    else{
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }
}
