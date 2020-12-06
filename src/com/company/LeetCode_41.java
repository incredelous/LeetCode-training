package com.company;


class LeetCode_41 {
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0) {
            return 1;
        }
        if(nums.length == 1 && nums[0] == 1) {
            return 2;
        }
        for(int i = 0; i < nums.length; i++) {
            while(nums[i] > 0 && nums[i] <= nums.length) {
                if(nums[nums[i] - 1] == nums[i]) {
                    break;
                }
                swap(nums, i, nums[i] - 1);
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
