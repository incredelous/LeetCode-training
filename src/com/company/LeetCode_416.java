package com.company;

public class LeetCode_416 {
    public boolean canPartition(int[] nums) {
        if(nums.length == 0) return false;
        int totalSum = 0;
        int maxValue = 0;
        for(int i = 0; i < nums.length; i++){
            totalSum += nums[i];
            if(nums[i] > maxValue) maxValue = nums[i];
        }
        if(totalSum % 2 != 0) return false;
        if(maxValue > totalSum / 2) return false;
        int target = totalSum / 2;
        boolean[][] dp = new boolean[nums.length][target+1];
        for(int i = 0;i < nums.length; i ++){
            dp[i][0] = true;
        }
        for(int i = 0; i < nums.length; i++){
            for(int j = 1; j <= target; j ++){
                if(i == 0){
                    if(j == nums[0]) dp[i][j] = true;
                    else dp[i][j] = false;
                }
                else{
                    if(nums[i] > j) dp[i][j] = dp[i-1][j];
                    else{
                        dp[i][j] = dp[i-1][j] == true ? true : dp[i-1][j - nums[i]];
                    }
                }
            }
        }
        return dp[nums.length-1][target];
    }
}
