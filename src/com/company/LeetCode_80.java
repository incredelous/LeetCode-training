package com.company;

import java.util.Arrays;

public class LeetCode_80 {
/**
 * Copyright (C), 2019-2019, citi Group
 * Filename: LeetCode_80
 * Author: wyf
 * Date: 20191008 21:38
 * Description: 删除排序数组中的重复项 II
 * History:
 *
 */
public int removeDuplicates(int[] nums) {
    /**
     * 更简单的方法：
     *         int i = 0;
     *         for (int n : nums){
     *             if (i < 2 || n > nums[i-2]){
     *                 nums[i] = n;
     *                 i++;
     *             }
     *         }
     *         return i;
     */
    int count = 1;
    int dup = 0;
    int len = nums.length;
    for(int i = 1; i < len; i++) {
        if(nums[i] == nums[i-1]) count++;
        else count = 1;
        if(count > 2) {
            nums[i] = Integer.MIN_VALUE + 1;
            dup++;
        }
    }
    int p = 0;
    count = 0;
    while(count <= dup && p < len){
        if(nums[p] == Integer.MIN_VALUE + 1) count++;
        else{nums[p - count] = nums[p]; }
        p++;
    }
    return len - count;
}
}
