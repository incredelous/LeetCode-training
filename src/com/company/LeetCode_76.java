package com.company;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_76 {
/**
 * Copyright (C), 2019-2019, citi Group
 * Filename: LeetCode_76
 * Author: wyf
 * Date: 20190924 21:24
 * Description: 最小覆盖子串
 * History:
 *
 */
public String minWindow(String s, String t) {
    //滑动窗口法
    Map<Character, Integer> t_count = new HashMap<>();
    if(t.length() == 0) return "";
    for(int i = 0; i < t.length(); i++) {
        int count = t_count.getOrDefault(t.charAt(i), 0);
        t_count.put(t.charAt(i), count + 1);
    }
    int t_total = t_count.size();
    int l = 0, r = 0;
    int[] ans = new int[]{-1, 0, 0};
    Map<Character, Integer> window_count = new HashMap<>();
    int window_total = 0;
    while(r < s.length()){
        char c = s.charAt(r);
        int count = window_count.getOrDefault(c, 0);
        window_count.put(c, count + 1);
        if(t_count.containsKey(c)&&window_count.get(c).intValue() == t_count.get(c).intValue()){
            window_total++;
        }

        while(l <= r && window_total == t_total){
            if(ans[0] == -1 || ans[0] >= r - l + 1)
            {
                ans[0] = r - l + 1;
                ans[1] = l;
                ans[2] = r;
            }
            c = s.charAt(l);
            window_count.put(c, window_count.get(c) - 1);
            if(t_count.containsKey(c) && window_count.get(c).intValue() < t_count.get(c).intValue()){
                window_total--;
            }
            l++;
        }
        r++;
    }
    return ans[0] == -1 ? "": s.substring(ans[1], ans[2]+1);
}
}
