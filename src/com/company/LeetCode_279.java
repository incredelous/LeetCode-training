package com.company;

public class LeetCode_279 {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int i = 1; i <= n; i++){
            int minValue = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++){
                minValue = Math.min(minValue, dp[i - j*j]);
            }
            dp[i] = 1 + minValue;
        }
        return dp[n];
    }
}
