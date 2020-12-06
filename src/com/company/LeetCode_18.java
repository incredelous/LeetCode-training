package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //四数之和
        ArrayList ret = new ArrayList();
        if(nums.length < 4) {
            return ret;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if(nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target)
                break;
            if(nums[i] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target)
                continue;
            for(int j = nums.length - 1; j > i + 2; j--) {
                if(j < nums.length - 1 && nums[j] == nums[j + 1]) {
                    continue;
                }
                int pointer1 = i + 1;
                int pointer2 = j - 1;
                while(pointer1 < pointer2) {
                    if(nums[i] + nums[j] + nums[pointer1] + nums[pointer2] == target) {
                        ret.add(Arrays.asList(nums[i], nums[j], nums[pointer1], nums[pointer2]));
                        while(pointer1 + 1 < pointer2 && nums[pointer1] == nums[pointer1 + 1]) {
                            pointer1++;
                        }
                        while(pointer1 < pointer2 - 1 && nums[pointer2] == nums[pointer2 - 1]) {
                            pointer2--;
                        }
                        pointer1++;
                    } else if(nums[i] + nums[j] + nums[pointer1] + nums[pointer2] < target) {
                        pointer1++;
                    } else {
                        pointer2--;
                    }
                }
            }
        }
        return ret;
    }
}
