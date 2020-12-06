package com.company;

import java.util.*;

public class LeetCode_49 {
    /**
     * Copyright (C), 2019-2019, citi Group
     * Filename: LeetCode_49
     * Author: wyf
     * Date: 20190819 23:01
     * Description: 字母异位词分组
     * History: v1 https://leetcode-cn.com/problems/group-anagrams/solution/zi-mu-yi-wei-ci-fen-zu-by-leetcode/ 解法一
     */

    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for(String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if(!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

}
