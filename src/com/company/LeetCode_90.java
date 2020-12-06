package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_90 {
/**
 * Copyright (C), 2019-2019, citi Group
 * Filename: LeetCode_90
 * Author: wyf
 * Date: 20191005 17:31
 * Description: 子集 II
 * History:
 *
 */
public List ret = new ArrayList();

    public void backTrace(int[] nums, List<Integer> tmp, int pos){
        ret.add(tmp.toArray());
        for(int i = pos; i < nums.length; i++) {
            if(i > pos && nums[i] == nums[i-1]) continue;
            tmp.add(nums[i]);
            backTrace(nums, tmp, i+1);
            tmp.remove(tmp.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> tmp = new ArrayList<>();
        backTrace(nums, tmp, 0);
        return ret;
    }
}
