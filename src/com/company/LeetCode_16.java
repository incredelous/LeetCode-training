package com.company;

import java.util.Arrays;

public class LeetCode_16 {
    //最接近的三数之和
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length < 3) {
            return Arrays.stream(nums).sum();
        }
        int dest = Integer.MAX_VALUE;
        int value = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            int pointer1 = i + 1;
            int pointer2 = nums.length - 1;
            while(pointer1 < pointer2) {

                if(nums[i] + nums[pointer1] + nums[pointer2] - target == 0) {
                    return target;
                }
                int temp = nums[i] + nums[pointer1] + nums[pointer2];
                if(temp < target) {
                    int closet = target - (nums[i] + nums[pointer1] + nums[pointer2]);
                    if(closet < dest) {
                        dest = closet;
                        value = temp;
                    }
                    pointer1++;
                } else {
                    int closet = nums[i] + nums[pointer1] + nums[pointer2] - target;
                    if(closet < dest) {
                        dest = closet;
                        value = temp;
                    }
                    pointer2--;
                }
            }
        }
        return value;
    }
}
