package com.company;

public class LeetCode_53 {
    /**
     * Copyright (C), 2019-2019, citi Group
     * Filename: LeetCode_53
     * Author: wyf
     * Date: 20190828 23:30
     * Description: 最大子序和
     * History:
     */
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            ans = Math.max(ans, sum);

        }
        return ans;
    }

}
