package com.company;

public class LeetCode_55 {
/**
 * Copyright (C), 2019-2019, citi Group
 * Filename: LeetCode_55
 * Author: wyf
 * Date: 20190831 23:00
 * Description: 跳跃游戏
 * History:
 *
 */
    public boolean canJump(int[] nums) {
        int last_pos = nums.length - 1;
        for(int i = nums.length - 2; i >= 0; i--) {
            if(i + nums[i] >= last_pos){ last_pos = i; }
        }
        return last_pos == 0;
    }
}
