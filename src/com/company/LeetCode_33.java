package com.company;

import java.util.Arrays;

public class LeetCode_33 {
    //搜索旋转排序数组
    public int search(int[] nums, int target) {
        if(nums.length == 0) {
            return -1;
        }
        int rotate_ind = findRotateIndex(nums);
        if(target == nums[0]) {
            return 0;
        }
        if(rotate_ind == 0) {
            return binaryPartitionSearch(Arrays.copyOfRange(nums, 0, nums.length), target);
        }
        if(target > nums[0]) {
            return binaryPartitionSearch(Arrays.copyOfRange(nums, 0, rotate_ind), target);
        } else {
            int ret = binaryPartitionSearch(Arrays.copyOfRange(nums, rotate_ind, nums.length), target);
            if(ret >= 0) {
                return ret + rotate_ind;
            } else {
                return -1;
            }
        }
    }

    public int findRotateIndex(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while(i <= j) {
            int pos = (i + j + 1) / 2; //防止只有两个数时，从位置0开始找，如[3,1]返回0
            if(pos == 0) {
                return 0;
            }
            if(nums[pos] < nums[pos - 1]) {
                return pos;
            } else if(nums[pos] < nums[0]) {
                j = pos - 1;
            } else {
                i = pos + 1;
            }
        }
        return 0;
    }

    public int binaryPartitionSearch(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while(i <= j) {
            int pos = (i + j + 1) / 2;
            if(nums[pos] == target) {
                return pos;
            } else if(nums[pos] < target) {
                i = pos + 1;
            } else {
                j = pos - 1;
            }
        }
        return -1;
    }
}
