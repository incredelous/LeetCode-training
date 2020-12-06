package com.company;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_28 {
    //实现strStr()函数
    public int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        if(len2 == 0) {
            return 0;
        }
        List<Integer> next = getNext(needle);
        int i = 0, j = 0;
        while(i < len1 && j < len2) {
            if(j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;

            } else {
                j = next.get(j);
            }
        }
        if(j == len2) return i - j;
        return -1;
    }

    public List<Integer> getNext(String pattern) {
        List<Integer> next = new ArrayList<>();
        next.add(-1);
        int j = 0, k = -1;
        while(j < pattern.length()) {
            if(k == -1 || pattern.charAt(j) == pattern.charAt(k)) {
                j++;
                k++;
                next.add(k);
            } else {
                k = next.get(k);
            }
        }
        return next;
    }
}
