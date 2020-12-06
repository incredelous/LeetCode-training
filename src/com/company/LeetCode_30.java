package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_30 {
/**
 * Copyright (C), 2019-2019, citi Group
 * Filename: LeetCode_30
 * Author: wyf
 * Date: 20190928 16:29
 * Description: 串联所有单词的字串
 * History:
 *
 */
public boolean isMatch(String sub, Map<String, Integer> words_count, int step){
    Map<String, Integer> window_count = new HashMap<>();
    int i = 0;
    int count;
    int words_total = words_count.size();
    int window_total = 0;
    String tmp;
    while(i < sub.length()){
        tmp = sub.substring(i, i+step);
        count = window_count.getOrDefault(tmp, 0);
        window_count.put(tmp, count + 1);
        if(!words_count.containsKey(tmp) || window_count.get(tmp).intValue() > words_count.get(tmp).intValue()){
            return false;
        }
        if(window_count.get(tmp).intValue() == words_count.get(tmp).intValue()){
            window_total++;
        }
        i += step;
    }
    return window_total == words_total ? true : false;

}

public List<Integer> findSubstring(String s, String[] words) {
    //滑动窗口法
    Map<String, Integer> words_count = new HashMap<>();
    int count;
    if(words.length == 0) return new ArrayList<Integer>();
    if(s.length() < words[0].length() * words.length) return new ArrayList<Integer>();
    for(int i = 0; i < words.length; i++) {
        count = words_count.getOrDefault(words[i], 0);
        words_count.put(words[i], count + 1);
    }
    List<Integer> ret = new ArrayList<>();
    int step = words[0].length();
    int l = 0, r = words.length * step;
    while(r <= s.length()){
        if(isMatch(s.substring(l, r), words_count, step)) ret.add(l);
        l++; r++;
    }
    return ret;
}
}
