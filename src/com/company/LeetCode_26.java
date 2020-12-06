package com.company;

public class LeetCode_26 {
    //    删除排序数组中的重复项
    public int removeDuplicates(int[] nums) {
        int len = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[len]) {
                nums[++len] = nums[i];
            }
        }
        return len++;
    }
}
