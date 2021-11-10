package com.company;

public class LeetCode_581 {
    public int findUnsortedSubarray(int[] nums) {
        int begin = 0;
        int end = -1;
        int max = nums[0];
        int min = nums[nums.length - 1];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= max){
                max = nums[i];
            } else end = i;
            if(nums[nums.length-i-1] <= min){
                min = nums[nums.length-i-1];
            } else begin = nums.length-i-1;
        }
        return end - begin + 1;
    }
}
