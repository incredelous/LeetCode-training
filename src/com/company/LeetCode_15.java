package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_15 {
    //三数之和
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList res = new ArrayList();
        if(nums.length < 3) {
            return res;
        }
        for(int i = 0; i < nums.length - 2; i++) {
            if(nums[i] > 0) {
                continue;
            }
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int pointer1 = i + 1;
            int pointer2 = nums.length - 1;
            while(pointer1 < pointer2) {
                if(nums[i] + nums[pointer1] + nums[pointer2] == 0) {
                    ArrayList re = new ArrayList();
                    re.add(nums[i]);
                    re.add(nums[pointer1]);
                    re.add(nums[pointer2]);
                    res.add(re);
                    while(pointer1 + 1 < pointer2 && nums[pointer1] == nums[pointer1 + 1]) {
                        pointer1++;
                    }
                    while(pointer1 < pointer2 - 1 && nums[pointer2] == nums[pointer2 - 1]) {
                        pointer2--;
                    }
                    pointer1++;
                } else if(nums[i] + nums[pointer1] + nums[pointer2] > 0) {
                    pointer2--;
                } else {
                    pointer1++;
                }
            }
        }
        return res;
    }
}
