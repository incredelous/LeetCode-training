package com.company;

public class LeetCode_338 {
    public int[] countBits(int n) {
        int[] dp = new int[n+1];
        int highBits = 0;
        for(int i = 1; i <= n; i++){
            if((i & (i-1)) == 0){ highBits = i;}
            dp[i] = dp[i - highBits] + 1;
        }
        return dp;
    }
}
