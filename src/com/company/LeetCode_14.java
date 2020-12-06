package com.company;

public class LeetCode_14 {
    //最长公共前缀
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) {
            return strs[0];
        }
        StringBuilder prefix = new StringBuilder();
        int min_length = Integer.MAX_VALUE;
        for(int i = 0; i < strs.length; i++) {
            if(strs[i].length() < min_length) {
                min_length = strs[i].length();
            }
        }
        for(int i = 0; i < min_length; i++) {
            int j = 1;
            for(; j < strs.length; j++) {
                if(strs[j].charAt(j) != strs[0].charAt(j)) {
                    break;
                }
            }
            if(j != strs.length) {
                break;
            } else {
                prefix.append(strs[0].charAt(j));
            }
        }
        return prefix.toString();
    }
}
