package com.company;

public class LeetCode_45 {
    /**
     * Copyright (C), 2019-2019, citi Group
     * Filename: LeetCode_45
     * Author: wyf
     * Date: 20190818 21:45
     * Description: 跳跃游戏II
     * History:
     * v1: 题解 https://leetcode-cn.com/problems/jump-game-ii/solution/qiu-mei-yi-tiao-de-fan-wei-by-da-fei-6/
     */

    public int jump(int[] nums) {
        if(nums.length == 1) {
            return 0;
        }
        int reach = 0, start = 0, step = 0;
        while(reach < nums.length - 1) {
            int farest = 0;
            for(int i = start; i <= reach; i++) {
                farest = Math.max(farest, nums[i] + i);
            }
            start = reach + 1;
            reach = farest;
            step++;
        }
        return step;
    }
}
