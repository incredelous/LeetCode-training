package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_40 {
    /*
     * 组合总和II
     * */
    List ret = new ArrayList();

    public void backTrace(int[] candidates, int target, List<Integer> ret_set, int start) {
        if(target == 0) {
            ret.add(ret_set.toArray());
        } else {
            for(int i = start; i < candidates.length; i++) {
                /*剪枝相同元素的搜索空间
                 * 如：[1,1,2,5]，索引为0的元素与索引为1的元素重复，
                 * 为使得解集合中的元素不重复，需要进行剪枝
                 * 但是规则允许一次搜索中可以选择索引值不同的重复元素，
                 * 使用条件i > start */

                if(i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                if(candidates[i] <= target) {
                    ret_set.add(candidates[i]);
                    backTrace(candidates, target - candidates[i], ret_set, i + 1);
                    ret_set.remove(ret_set.size() - 1);
                }
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> ret_set = new ArrayList();
        Arrays.sort(candidates);
        backTrace(candidates, target, ret_set, 0);
        return ret;
    }
}
