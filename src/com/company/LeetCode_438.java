package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_438 {
/**
 * Copyright (C), 2019-2019, citi Group
 * Filename: LeetCode_438
 * Author: wyf
 * Date: 20190929 19:02
 * Description: 找到字符串中所有字母异位词
 * History:
 *
 */
public boolean isMatch(int[] p_count, int[] s_count){
    for(int i = 0; i < 26; i++) {
        if(p_count[i] != s_count[i]) return false;
    }
    return true;
}
public List<Integer> findAnagrams(String s, String p) {
    //滑动窗口法
    if(p.length() == 0 || s.length() < p.length()) return new ArrayList<>();
    List<Integer> ret = new ArrayList<>();
    int[] p_count = new int[26];
    int[] s_count = new int[26];
    for(int i = 0; i < p.length(); i++) {
        p_count[p.charAt(i) - 97]++;
        s_count[s.charAt(i) - 97]++;
    }
    int l = 0, r = p.length();
    while(r < s.length()){
        if(isMatch(p_count, s_count)) ret.add(l);
        s_count[s.charAt(r++) - 97]++;
        s_count[s.charAt(l++) - 97]--;
    }
    if(isMatch(p_count, s_count)) ret.add(l);
    return ret;
}
}
