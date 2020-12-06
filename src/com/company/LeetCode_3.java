package com.company;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_3 {
    //无重复字符串的最长字串
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max_length = 0;
        int start = 0;
        int temp_length = 0;
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                int pos = map.get(s.charAt(i));
                int diff = pos - start;
                for(int j = start; j <= pos; j++) {
                    map.remove(s.charAt(j));
                }
                start = pos + 1;
                map.put(s.charAt(i), i);
                temp_length -= diff;

            } else {
                map.put(s.charAt(i), i);
                temp_length++;
                if(temp_length > max_length) {
                    max_length = temp_length;
                }
            }
        }
        if(temp_length > max_length) {
            max_length = temp_length;
        }
        return max_length;
    }
}
