package com.company;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_39 {
    /*
    * 组合总和
    * v1:(2019/8/10)
    * 执行用时 :6 ms, 在所有 Java 提交中击败了93.69% 的用户
      内存消耗 :39.1 MB, 在所有 Java 提交中击败了87.58%的用户*/

    List ret = new ArrayList();

    public void backTrace(int[] candidates, int target, List<Integer> ret_set, int start) {
        if(target == 0) {
            ret.add(ret_set.toArray());
        } else {
            for(int i = start; i < candidates.length; i++) {
                if(candidates[i] <= target) {
                    ret_set.add(candidates[i]);
                    backTrace(candidates, target - candidates[i], ret_set, i);
                    ret_set.remove(ret_set.size() - 1);
                }
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> ret_set = new ArrayList();
        backTrace(candidates, target, ret_set, 0);
        return ret;
    }
}
