package com.company;


public class LeetCode_31 {
    //下一个排列
    public void nextPermutation(int[] nums) {
//        List<Integer> max_values = new ArrayList<>();
        if(nums.length == 1) {
            return;
        }
        int max_temp = nums[nums.length - 1];
//        max_values.add(max_temp);
        int i;
        for(i = nums.length - 2; i >= 0; i--) {
            if(max_temp > nums[i]) {
                int j = nums.length - 1;
                while(nums[j] <= nums[i]) {
                    j--;
                }
                swap(nums, i, j);
                reverseItoJ(nums, i + 1, nums.length - 1);
                break;
            } else {
                max_temp = nums[i];
            }
        }
        if(i < 0) {
            reverseItoJ(nums, 0, nums.length - 1);
        }
        return;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //
    public void reverseItoJ(int[] nums, int i, int j) {
        while(i <= j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
