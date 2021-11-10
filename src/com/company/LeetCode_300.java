package com.company;

public class LeetCode_300 {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int maxLength = dp[0];
        for(int i = 0; i < nums.length; i++){
            maxLength = Math.max(dp[i], maxLength);
        }
        return maxLength;
    }
}
