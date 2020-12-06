package com.company;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_78 {
/**
 * Copyright (C), 2019-2019, citi Group
 * Filename: LeetCode_78
 * Author: wyf
 * Date: 20191005 16:50
 * Description: 子集
 * History:
 *
 */
public List ret = new ArrayList();

public void backTrace(int[] nums, List<Integer> tmp, int pos){
    if(pos >= nums.length){
        ret.add(tmp.toArray());
    }
    else{
        backTrace(nums, tmp, pos+1);
        tmp.add(nums[pos]);
        backTrace(nums, tmp, pos+1);
        tmp.remove(tmp.size() - 1);
    }
}

public List<List<Integer>> subsets(int[] nums) {
    List<Integer> tmp = new ArrayList<>();
    backTrace(nums, tmp, 0);
    return ret;
}
}
