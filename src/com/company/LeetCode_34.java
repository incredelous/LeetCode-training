package com.company;

public class LeetCode_34 {
    //在排序数组中查找元素的第一个和最后一个位置
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) {
            return new int[]{-1, -1};
        }
        int i = 0;
        int j = nums.length - 1;
        int[] ret = new int[]{-1, -1};
        while(i <= j) {
            int pos = (i + j + 1) / 2;
            if(pos == 0 && nums[pos] == target) {
                ret[0] = 0;
                break;
            }
            if(nums[pos] == target && nums[pos] > nums[pos - 1]) {
                ret[0] = pos;
                break;
            } else if(nums[pos] < target) {
                i = pos + 1;
            } else {
                j = pos - 1;
            }
        }
        i = 0;
        j = nums.length - 1;
        while(i <= j) {
            int pos = (i + j + 1) / 2;
            if(pos == nums.length - 1 && nums[pos] == target) {
                ret[1] = nums.length - 1;
                break;
            }
            if(nums[pos] == target && nums[pos] < nums[pos + 1]) {
                ret[1] = pos;
                break;
            } else if(nums[pos] > target) {
                j = pos - 1;
            } else {
                i = pos + 1;
            }
        }
        return ret;
    }
}
