package com.company;

public class LeetCode_494 {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for(int i = 0; i < nums.length; i++){
            totalSum += nums[i];
        }
        int neg = totalSum - target;
        if(neg < 0 || neg % 2 != 0) return 0;
        int[][] dp = new int[nums.length + 1][neg / 2 + 1];
        for(int i = 0; i <= nums.length; i++){
            for(int j = 0; j <= neg/2; j++){
                if(i == 0){
                    if(j == 0) dp[i][j] = 1;
                    else dp[i][j] = 0;
                }
                else{
                    if(j < nums[i-1]) dp[i][j] = dp[i-1][j];
                    else dp[i][j] = dp[i-1][j] + dp[i-1][j - nums[i-1]];
                }
            }
        }
        return dp[nums.length][neg/2];
    }
}