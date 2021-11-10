package com.company;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_437 {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0L, 1);
        return dfs(root, 0, prefixSum, targetSum);
    }

    public int dfs(TreeNode root, long curr, Map<Long, Integer> prefixSum, int targetSum){
        if(root == null) return 0;

        curr += root.val;
        int ret = prefixSum.getOrDefault(curr-targetSum, 0);
        prefixSum.put(curr, prefixSum.getOrDefault(curr, 0) + 1);
        ret += dfs(root.left, curr, prefixSum, targetSum);
        ret += dfs(root.right, curr, prefixSum, targetSum);
        prefixSum.put(curr, prefixSum.getOrDefault(curr, 0) - 1);

        return ret;
    }
}