package com.company;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_1 {
    public int[] twoSum(int[] nums, int target) {
        //两数之和
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int rest = target - nums[i];
            if(map.containsKey(rest)) {
                return new int[]{map.get(rest), i};
            } else {
                map.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("no result!");
    }
}
